package com.zakdroid.candysuharnica.data.model

data class CatalogItem(
    val id: Int?,
    val name: String?,
    val type: String?, //for filter in the groups
    val weight: Int?,
    val imgUrl: String?,
    val price: Double?,
    val priceSale: Double?,
    val likes: Int?,
)
