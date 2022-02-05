package com.zakdroid.candysuharnica.data.dbRoom.catalog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.zakdroid.candysuharnica.utils.StringArrayConverter

@Entity(tableName = "catalog")
@TypeConverters(StringArrayConverter::class)

data class CatalogItemDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "imgUrl") val imgUrl: List<String>,
    @ColumnInfo(name = "likes") val likes: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "priceSale") val priceSale: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "about") val about: String,
    @ColumnInfo(name = "product_composition") val product_composition: List<String>,
    @ColumnInfo(name = "nutritional_value") val nutritional_value: List<String>,
    @ColumnInfo(name = "type") val type: String
) {

    fun toCatalogItem(): CatalogItem = CatalogItem(
        id = id.toString(),
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

    companion object {
        fun fromCatalogItem(item: CatalogItem): CatalogItemDbEntity {
            return CatalogItemDbEntity(
                id = 0,
                name = item.name,
                type = item.type,
                weight = item.weight,
                imgUrl = item.imgUrl,
                price = item.price,
                priceSale = item.priceSale,
                likes = item.likes,
                about = item.about,
                product_composition = item.product_composition,
                nutritional_value = item.nutritional_value
            )
        }
    }
}