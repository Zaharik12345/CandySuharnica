package com.zakdroid.candysuharnica.data.model.catalog

data class CatalogResponse (
    var catalogItems: List<CatalogItem>? = null,
    var exception: Exception? = null
        )