package com.zakdroid.candysuharnica.screens.basket

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.AppDatabase

class BasketViewModel: ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    fun getListFromQuery(query: String) = db.basketDao()
        .getListFromQuery(query = query.plus("%"))
        .map { it.toBasketItem() }

    fun getCount() = db.basketDao().getCount()

    fun getAmountPrice() = db.basketDao().getAmountPrice()
}