package com.zakdroid.candysuharnica.ui.main.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zakdroid.candysuharnica.data.FirebaseCallback
import com.zakdroid.candysuharnica.data.model.CatalogResponse
import com.zakdroid.candysuharnica.data.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers

class CatalogViewModel (
    private val repository: CatalogRepository = CatalogRepository()
        ): ViewModel() {

    fun getResponseUsingCallback(callback: FirebaseCallback) {
        repository.getResponseFromRealtimeDatabaseUsingCallback(callback)
    }

    fun getResponseUsingLiveData() : LiveData<CatalogResponse> {
        return repository.getResponseFromRealtimeDatabaseUsingLiveData()
    }

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.getResponseFromRealtimeDatabaseUsingCoroutines())
    }

}