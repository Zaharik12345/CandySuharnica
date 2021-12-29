package com.zakdroid.candysuharnica.data.model

data class CatalogResponse (
    var catalogItems: List<CatalogItem>? = null,
    var exception: Exception? = null
        )