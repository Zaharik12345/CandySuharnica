package com.zakdroid.candysuharnica.data

import com.zakdroid.candysuharnica.data.model.CatalogResponse

interface FirebaseCallback {
    fun onResponseCatalogItems(response: CatalogResponse)
}