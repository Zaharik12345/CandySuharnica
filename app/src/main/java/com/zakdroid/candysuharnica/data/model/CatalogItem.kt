package com.zakdroid.candysuharnica.data.model

data class CatalogItem(
    val id: String? = "",
    val name: String? = "",
    val type: String? = "", //for filter in the groups
    val weight: String? = "",
    val imgUrl: String? = "",
    val price: String? = "",
    val priceSale: String? = "",
    var likes: String? = "",
    var isLiked: Boolean = false
)
