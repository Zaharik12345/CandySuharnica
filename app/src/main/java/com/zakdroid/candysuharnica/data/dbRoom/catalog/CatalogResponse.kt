package com.zakdroid.candysuharnica.data.dbRoom.catalog


data class CatalogResponse (
    var catalogItems: List<CatalogItem>? = null,
    var exception: Exception? = null
        )