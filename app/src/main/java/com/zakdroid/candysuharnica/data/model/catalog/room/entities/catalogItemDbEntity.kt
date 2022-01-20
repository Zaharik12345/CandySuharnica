package com.zakdroid.candysuharnica.data.model.catalog.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.data.model.catalog.CatalogItem

@Entity(tableName = "catalog")

data class catalogItemDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: String,
    @ColumnInfo(name = "imgUrl") val imgUrl: String,
    @ColumnInfo(name = "likes") val likes: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "priceSale") val priceSale: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "about") val about: String,
    @ColumnInfo(name = "product_composition") val product_composition: String,
    @ColumnInfo(name = "nutritional_value") val nutritional_value: String,
    @ColumnInfo(name = "type") val type: String
) {

    fun toCatalogItem():CatalogItem = CatalogItem(
        id = id,
        name = name,
        type = type,
        weight = weight,
        imgUrl = imgUrl,
        price = price,
        priceSale = priceSale,
        likes = likes,
        about = about,
        product_composition = product_composition,
        nutritional_value = nutritional_value
    )
}