package com.zakdroid.candysuharnica.model.dbRoom.catalog

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
) : Parcelable{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CatalogItem

        if (name != other.name) return false
        if (type != other.type) return false
        if (weight != other.weight) return false
        if (imgUrl != other.imgUrl) return false
        if (price != other.price) return false
        if (priceSale != other.priceSale) return false
        if (likes != other.likes) return false
        if (about != other.about) return false
        if (product_composition != other.product_composition) return false
        if (nutritional_value != other.nutritional_value) return false
        if (isLiked != other.isLiked) return false

        return true
    }
    fun equalsWithoutIsLiked(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CatalogItem

        if (name != other.name) return false
        if (type != other.type) return false
        if (weight != other.weight) return false
        if (imgUrl != other.imgUrl) return false
        if (price != other.price) return false
        if (priceSale != other.priceSale) return false
        if (likes != other.likes) return false
        if (about != other.about) return false
        if (product_composition != other.product_composition) return false
        if (nutritional_value != other.nutritional_value) return false

        return true
    }
}
