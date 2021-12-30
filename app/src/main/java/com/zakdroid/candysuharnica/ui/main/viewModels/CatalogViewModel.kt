package com.zakdroid.candysuharnica.ui.main.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zakdroid.candysuharnica.data.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers

class CatalogViewModel (
    private val repository: CatalogRepository = CatalogRepository()
        ): ViewModel() {


    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.getResponseFromRealtimeDatabaseUsingCoroutines())
    }

}