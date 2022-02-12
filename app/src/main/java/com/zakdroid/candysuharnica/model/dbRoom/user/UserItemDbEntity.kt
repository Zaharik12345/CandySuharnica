package com.zakdroid.candysuharnica.model.dbRoom.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity

@Entity(tableName = "user")

data class UserDbEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "password") val password: String,
   // @ColumnInfo(name = "mobile_number") val mobile_number: String,
   // @ColumnInfo(name = "address") val address: String
) {
    fun toUser(): User = User(
        id = id,
        name = name,
        password = password
    )

    companion object {
        fun fromUser(user: User): UserDbEntity {
            return UserDbEntity(
                id = 0,
                name = user.name,
                password = user.password
                )
        }
    }
}