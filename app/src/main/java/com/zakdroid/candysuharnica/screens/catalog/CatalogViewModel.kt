package com.zakdroid.candysuharnica.screens.catalog

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.data.dbRoom.AppDatabase
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItem


class CatalogViewModel(application: Application) : AndroidViewModel(application) {


    private val db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")
    private val listItems = db.catalogDao().getAll().map { it.toCatalogItem() }
    private val listTypeOfItems = listItems.map { it.type }.distinct()

    fun getListFromType(type: String): List<CatalogItem> {
        return if (type == CatalogFragment.START_WORD) listItems
        else db.catalogDao().getFromType(type).map { it.toCatalogItem() }
    }

    fun getListType() = listTypeOfItems

}