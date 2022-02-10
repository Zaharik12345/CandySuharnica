package com.zakdroid.candysuharnica.screens.basket

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.FragmentBasketBinding
import com.zakdroid.candysuharnica.utils.adapters.AdapterRCBasket


class BasketFragment : Fragment(R.layout.fragment_basket) {

    private lateinit var viewModel: BasketViewModel
    private lateinit var binding: FragmentBasketBinding

    private val adapter = AdapterRCBasket()
    private var currentQuery = ""
    private lateinit var countDeserts: String
    private lateinit var price: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BasketViewModel::class.java)
        with(viewModel) {
            countDeserts = getCount().toString()
            price = getAmountPrice().toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketBinding.bind(view)

        binding.rvBasket.adapter = adapter


        binding.tvCountOfOrderItem.text = when (countDeserts) {
            "1" -> countDeserts.plus(" десерт")
            "2","3","4" -> countDeserts.plus(" десерта")
            else -> countDeserts.plus(" десертов")
        }
        binding.tvPriceOfOrder.text = price.plus(" BYN")

        binding.etSearch.addTextChangedListener {
            currentQuery = it.toString()
            notifyRecyclerViewItem()
        }
    }

    private fun notifyRecyclerViewItem() {
        adapter.basketItems = viewModel.getListFromQuery(currentQuery)
    }


}