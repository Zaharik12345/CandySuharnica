package com.zakdroid.candysuharnica.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "basket",
    foreignKeys = [ForeignKey(
        entity = CatalogItemDbEntity::class,
        parentColumns = ["id"],
        childColumns = ["product_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class BasketDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "product_id") val product_id: Int,
    @ColumnInfo(name = "count") val count: String,
    @ColumnInfo(name = "price_sum") val price_sum: String
) {

}