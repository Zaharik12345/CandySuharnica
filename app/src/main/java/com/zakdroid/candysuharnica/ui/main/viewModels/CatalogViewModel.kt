package com.zakdroid.candysuharnica.ui.main.viewModels

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.data.dbRoom.AppDatabase

class CatalogViewModel : ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    fun getList() = db.catalogDao().getAll().map { it.toCatalogItem() }

}