package com.zakdroid.candysuharnica.screens.catalog

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.data.dbRoom.AppDatabase
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItem

class CatalogViewModel : ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    fun getList() = db.catalogDao().getAll().map { it.toCatalogItem() }

    //fun getListType(List<CatalogItem>) = Lis

}