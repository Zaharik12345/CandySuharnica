package com.zakdroid.candysuharnica.model.dbRoom.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem

@Entity(tableName = "user")

data class UserItemDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "first_name") val first_name: String,
    @ColumnInfo(name = "second_name") val second_name: String,
    @ColumnInfo(name = "mobile_number") val mobile_number: String,
    @ColumnInfo(name = "address") val address: String
) {
    fun toUserItem(): UserItem = UserItem(
        id = id,
        first_name = first_name,
        second_name = second_name,
        mobile_number = mobile_number,
        address = address
    )
    companion object{
        fun fromUserItem(item: UserItem): UserItemDbEntity{
            return UserItemDbEntity(
                id = 0,
                first_name = item.first_name,
                second_name = item.second_name,
                mobile_number = item.mobile_number,
                address = item.address
            )
        }
    }
}