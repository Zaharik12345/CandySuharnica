package com.zakdroid.candysuharnica.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.databinding.ItemBasketBinding

class AdapterRCBasket : RecyclerView.Adapter<BasketHolder>() {

    var basketItems: List<BasketItem> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBasketBinding.inflate(layoutInflater, parent, false)

        return BasketHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        val basketItem = basketItems[position]

        with(holder.binding){
            ivProductIconBasketItem.load(basketItem.imgURL)
            tvProductTitleBasketItem.text = basketItem.name
            tvPriceBasketItem.text = basketItem.amountPrice.toString().plus(" BYN")
            tvAmountWeight.text = basketItem.amountWeight.toString().plus(" г")
            tvAmountOfProductBasketItem.text = basketItem.count.toString()
        }
    }

    override fun getItemCount(): Int = basketItems.size


}

class BasketHolder(
    val binding: ItemBasketBinding
) : RecyclerView.ViewHolder(binding.root)