package com.zakdroid.candysuharnica.data.dbRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketDao
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogDao
import com.zakdroid.candysuharnica.data.dbRoom.user.UserDao
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketDbEntity
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItemDbEntity
import com.zakdroid.candysuharnica.data.dbRoom.user.UserItemDbEntity


@Database(
    version = 1,
    entities = [
        CatalogItemDbEntity::class,
        UserItemDbEntity::class,
        BasketDbEntity::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun catalogDao(): CatalogDao

    abstract fun userDao(): UserDao

    abstract fun basketDao(): BasketDao
}

