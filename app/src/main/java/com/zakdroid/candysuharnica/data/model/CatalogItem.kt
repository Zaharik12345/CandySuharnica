package com.zakdroid.candysuharnica.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CatalogItem(
    val id: String = "",
    val name: String = "",
    val type: String = "", //for filter in the groups
    val weight: String = "",
    val imgUrl: List<String> = emptyList(),
    val price: String = "",
    val priceSale: String = "",
    var likes: String = "",
    var about: String = "",
    var product_composition: List<String> = emptyList(),
    var nutritional_value: List<String> = emptyList(),
    var isLiked: Boolean = false
) : Parcelable
