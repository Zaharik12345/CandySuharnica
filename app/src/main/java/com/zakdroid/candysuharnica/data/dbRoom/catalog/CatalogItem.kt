package com.zakdroid.candysuharnica.data.dbRoom.catalog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CatalogItem(
    val id: Int = 0,
    val name: String = "",
    val type: String = "", //for filter in the groups
    val weight: Int = 0,
    val imgUrl: List<String> = emptyList(),
    val price: Double = 0.0,
    val priceSale: Double = 0.0,
    var likes: Int = 0,
    var about: String = "",
    var product_composition: List<String> = emptyList(),
    var nutritional_value: List<String> = emptyList(),
    var isLiked: Boolean = false
) : Parcelable
