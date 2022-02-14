package com.zakdroid.candysuharnica.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.AppDatabase
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogResponse
import com.zakdroid.candysuharnica.model.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers

class SplashViewModel(
    private val repository: CatalogRepository = CatalogRepository()
) : ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.getResponseFromRealtimeDatabase())
    }

    fun fillDB(list: CatalogResponse) {
        if(list.exception == null && list.catalogItems != null){
            val oldList = db.catalogDao().getAll().map { it.toCatalogItem() }
            val newList = list.catalogItems

            if (oldList != newList){
                db.catalogDao().deleteTable()
                for (item in list.catalogItems!!) {
                    val itemCatalog = CatalogItemDbEntity.fromCatalogItem(item)
                    db.catalogDao().insert(itemCatalog)
                }
            }
        }
    }

}
