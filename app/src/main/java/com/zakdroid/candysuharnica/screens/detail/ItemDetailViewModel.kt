package com.zakdroid.candysuharnica.screens.detail

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketDbEntity
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem

class ItemDetailViewModel : ViewModel() {

    private val db = App.instance?.getDatabase() ?: throw Exception("error")

    fun addToBasket(catalogItem: CatalogItem) {
        val oldItem = db.basketDao().getItemFromId(catalogItem.id)
        if (oldItem == null) {
            val newItem = BasketDbEntity(
                id = 0,
                productId = catalogItem.id,
                name = catalogItem.name,
                count = 1,
                imgURL = catalogItem.imgUrl[0],
                amountPrice = catalogItem.price,
                amountWeight = catalogItem.weight
            )
            db.basketDao().insert(newItem)
        } else {
            val newItem = BasketDbEntity(
                id = oldItem.id,
                productId = oldItem.productId,
                name = oldItem.name,
                count = oldItem.count + 1,
                imgURL = oldItem.imgURL,
                amountPrice = oldItem.amountPrice + catalogItem.price,
                amountWeight = oldItem.amountWeight + catalogItem.weight
            )
            db.basketDao().update(newItem)
        }


    }

    fun removeToBasket(catalogItem: CatalogItem) {
        val oldItem = db.basketDao().getItemFromId(catalogItem.id)
        if (oldItem != null && getCountFromId(catalogItem.id) != "0" && getCountFromId(catalogItem.id) != "1") {
            val newItem = BasketDbEntity(
                id = oldItem.id,
                productId = oldItem.productId,
                name = oldItem.name,
                count = oldItem.count - 1,
                imgURL = oldItem.imgURL,
                amountPrice = oldItem.amountPrice - catalogItem.price,
                amountWeight = oldItem.amountWeight - catalogItem.weight
            )
            db.basketDao().update(newItem)
        } else if (oldItem != null && getCountFromId(catalogItem.id) == "1") {
            db.basketDao().delete(oldItem)
        }
    }

    fun getCountFromId(id: Int): CharSequence = db.basketDao().getCountFromId(id).toString()
}
