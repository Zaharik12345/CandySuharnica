package com.zakdroid.candysuharnica.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")

data class UserItemDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: String,
    @ColumnInfo(name = "first_name") val first_name: String,
    @ColumnInfo(name = "second_name") val second_name: String,
    @ColumnInfo(name = "mobile_number") val mobile_number: String,
    @ColumnInfo(name = "address") val address: String
) {
    //fun toUserItem() //todo you need to create UserItem
}