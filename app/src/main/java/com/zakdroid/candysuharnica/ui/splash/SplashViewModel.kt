package com.zakdroid.candysuharnica.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.data.db.AppDatabase
import com.zakdroid.candysuharnica.data.db.entity.CatalogItemDbEntity
import com.zakdroid.candysuharnica.data.model.CatalogResponse
import com.zakdroid.candysuharnica.data.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers

class SplashViewModel(
    private val repository: CatalogRepository = CatalogRepository()
) : ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.getResponseFromRealtimeDatabase())
    }

    fun fillDB(list: CatalogResponse) {
        if(list.exception == null){
            db.catalogDao().deleteTable()
            for (item in list.catalogItems!!) {
                val itemCatalog = CatalogItemDbEntity.fromCatalogItem(item)
                db.catalogDao().insert(itemCatalog)
            }
        }
    }

}
