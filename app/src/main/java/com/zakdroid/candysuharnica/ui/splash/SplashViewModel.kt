package com.zakdroid.candysuharnica.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.zakdroid.candysuharnica.data.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: CatalogRepository = CatalogRepository()
) : ViewModel() {

    init {
        val responseLiveData = liveData(Dispatchers.IO) {
            emit(repository.getResponseFromRealtimeDatabaseUsingCoroutines())
        }
    }
}
