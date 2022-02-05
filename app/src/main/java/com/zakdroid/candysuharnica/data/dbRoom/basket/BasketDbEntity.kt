package com.zakdroid.candysuharnica.data.dbRoom.basket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItemDbEntity

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
    @ColumnInfo(name = "product_id") val productId: Int,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "price_sum") val amountPrice: Int
) {

    fun toBasketItem(): BasketItem = BasketItem(
        id = id,
        productId = productId,
        count = count,
        amountPrice = amountPrice
    )

    companion object {
        fun fromBasketItem(item: BasketItem): BasketDbEntity {
            return BasketDbEntity(
                id = 0,
                productId = item.productId,
                count = item.count,
                amountPrice = item.amountPrice
            )
        }
    }
}