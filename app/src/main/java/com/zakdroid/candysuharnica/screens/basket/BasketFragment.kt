package com.zakdroid.candysuharnica.screens.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.data.dbRoom.AppDatabase
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.databinding.FragmentBasketBinding
import com.zakdroid.candysuharnica.utils.adapters.AdapterRCBasket


class BasketFragment : Fragment(R.layout.fragment_basket) {

    private lateinit var listBasket: List<BasketItem>

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    private lateinit var binding: FragmentBasketBinding

    private val adapter = AdapterRCBasket()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listBasket = db.basketDao().getAll().map { it.toBasketItem() }
        adapter.basketItems =listBasket
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketBinding.bind(view)

        binding.rvBasket.adapter = adapter
        val countDeserts = db.basketDao().getCount()
        val price = db.basketDao().getAmountPrice()
        binding.tvCountOfOrderItem.text = when(countDeserts){
            1 -> countDeserts.toString().plus(" десерт")
            in 2..4 -> countDeserts.toString().plus(" десерта")
            else -> countDeserts.toString().plus(" десертов")
        }
        binding.tvPriceOfOrder.text = price.toString().plus(" BYN")
    }


}