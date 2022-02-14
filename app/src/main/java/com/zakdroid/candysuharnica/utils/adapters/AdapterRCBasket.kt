package com.zakdroid.candysuharnica.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.databinding.ItemBasketBinding
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketDbEntity
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem
import com.zakdroid.candysuharnica.screens.basket.BasketFragment

class BasketItemsDiffUtil(
    private val newList: List<BasketItem>,
    private val oldList: List<BasketItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}

class AdapterRCBasket : RecyclerView.Adapter<BasketHolder>(), View.OnClickListener {


    var basketItems: List<BasketItem> = emptyList()
        set(newValue) {
            val diffUtil = BasketItemsDiffUtil(newValue, field)
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }
    private lateinit var fragment: BasketFragment


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBasketBinding.inflate(layoutInflater, parent, false)
        fragment = parent.findFragment<BasketFragment>()
        return BasketHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        val basketItem = basketItems[position]

        with(holder.binding) {
            ivProductIconBasketItem.load(basketItem.imgURL)
            tvProductTitleBasketItem.text = basketItem.name
            tvPriceBasketItem.text = basketItem.amountPrice.toString().plus(" BYN")
            tvAmountWeight.text = basketItem.amountWeight.toString().plus(" г")
            tvCount.text = basketItem.count.toString()

            ibAddBasketItem.tag = basketItem
            ibRemoveFromBasketItem.tag = basketItem
            ibRemoveAllItems.tag = basketItem

            ibAddBasketItem.setOnClickListener(this@AdapterRCBasket)
            ibRemoveFromBasketItem.setOnClickListener(this@AdapterRCBasket)
            ibRemoveAllItems.setOnClickListener(this@AdapterRCBasket)
        }
    }

    override fun getItemCount(): Int = basketItems.size

    override fun onClick(v: View) {

        val oldItem = v.tag as BasketItem
        val db = App.instance?.getDatabase() ?: throw Exception("error")
        val price = db.catalogDao().getPriceFRomId(oldItem.productId)
        val weight = db.catalogDao().getWeightFRomId(oldItem.productId)

        v.context

        when (v.id) {
            R.id.ib_add_basket_item -> {
                val newItem = BasketDbEntity(
                    id = oldItem.id,
                    productId = oldItem.productId,
                    name = oldItem.name,
                    count = oldItem.count + 1,
                    imgURL = oldItem.imgURL,
                    amountPrice = oldItem.amountPrice + price,
                    amountWeight = oldItem.amountWeight + weight
                )
                db.basketDao().update(newItem)
            }

            R.id.ib_remove_from_basket_item -> {
                if (oldItem.count == 1){
                    val basketDbEntity = BasketDbEntity.fromBasketItem(oldItem)
                    db.basketDao().delete(basketDbEntity)
                }else{
                    val newItem = BasketDbEntity(
                        id = oldItem.id,
                        productId = oldItem.productId,
                        name = oldItem.name,
                        count = oldItem.count - 1,
                        imgURL = oldItem.imgURL,
                        amountPrice = oldItem.amountPrice - price,
                        amountWeight = oldItem.amountWeight - weight
                    )
                    db.basketDao().update(newItem)
                }
            }
            R.id.ib_remove_all_items -> {
                val basketDbEntity = BasketDbEntity.fromBasketItem(oldItem)
                db.basketDao().delete(basketDbEntity)
            }
            else -> {}
        }
        val newList = db.basketDao().getAll().map { it.toBasketItem() }
        basketItems = newList
        fragment.notifyOrderPanel()
    }

}

class BasketHolder(
    val binding: ItemBasketBinding
) : RecyclerView.ViewHolder(binding.root)