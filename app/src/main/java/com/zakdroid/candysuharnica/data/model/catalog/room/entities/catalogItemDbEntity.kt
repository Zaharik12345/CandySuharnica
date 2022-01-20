package com.zakdroid.candysuharnica.data.model.catalog.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.data.model.catalog.CatalogItem

@Entity(tableName = "catalog")

data class catalogItemDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "imgUrl") val imgUrl: String,
    @ColumnInfo(name = "likes") val likes: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "priceSale") val priceSale: String,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "about") val about: String,
    @ColumnInfo(name = "product_composition") val product_composition: String,
    @ColumnInfo(name = "nutritional_value") val nutritional_value: String,
    @ColumnInfo(name = "type_id") val type_id: Int
) {

    fun toCatalogItem():CatalogItem = CatalogItem(
        id = id.toString(),
        name = name,
        type_id = type_id.toString(),
        weight = weight.toString(),
        imgUrl = imgUrl,
        price = price,
        priceSale = priceSale,
        likes = likes.toString()
    )
}