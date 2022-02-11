package com.zakdroid.candysuharnica.model.dbRoom.catalog


data class CatalogResponse (
    var catalogItems: List<CatalogItem>? = null,
    var exception: Exception? = null
        )