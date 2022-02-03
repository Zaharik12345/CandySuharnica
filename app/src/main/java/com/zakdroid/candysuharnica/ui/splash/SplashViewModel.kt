package com.zakdroid.candysuharnica.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.data.db.AppDatabase
import com.zakdroid.candysuharnica.data.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: CatalogRepository = CatalogRepository()
) : ViewModel() {

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    init {
        val responseLiveData = liveData(Dispatchers.IO) {
            emit(repository.getResponseFromRealtimeDatabaseUsingCoroutines())
        }

        fun fillDB(){
           // db.catalogDao().insert()
        }
    }
}
