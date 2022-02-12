package com.zakdroid.candysuharnica.screens.detail

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketDbEntity
import com.zakdroid.candysuharnica.model.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem

class ItemDetailViewModel : ViewModel() {

    private val db = App.instance?.getDatabase() ?: throw Exception("error")

    fun addToBasket(catalogItem: CatalogItem) {
        val basketItems = db.basketDao().getAll().map { it.toBasketItem() }
        val itemDbEntity = BasketDbEntity.fromBasketItem(BasketItem())
    }

    fun removeToBasket(catalogItem: CatalogItem) {
        TODO("Not yet implemented")
    }
}
