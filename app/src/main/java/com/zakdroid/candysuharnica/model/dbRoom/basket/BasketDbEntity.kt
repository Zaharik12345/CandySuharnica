package com.zakdroid.candysuharnica.model.dbRoom.basket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity

@Entity(
    tableName = "basket",
    /*foreignKeys = [ForeignKey(
        entity = CatalogItemDbEntity::class,
        parentColumns = ["id"],
        childColumns = ["product_id"],
        //onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]*/
)
data class BasketDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "product_id") val productId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "imgURL") val imgURL: String,
    @ColumnInfo(name = "price_sum") val amountPrice: Double,
    @ColumnInfo(name = "weight_sum") val amountWeight: Int
) {

    fun toBasketItem(): BasketItem = BasketItem(
        id = id,
        productId = productId,
        name = name,
        count = count,
        imgURL= imgURL,
        amountWeight = amountWeight,
        amountPrice = amountPrice
    )

    companion object {
        fun fromBasketItem(item: BasketItem): BasketDbEntity {
            return BasketDbEntity(
                id = item.id,
                productId = item.productId,
                name = item.name,
                count = item.count,
                imgURL = item.imgURL,
                amountWeight = item.amountWeight,
                amountPrice = item.amountPrice
            )
        }
    }
}