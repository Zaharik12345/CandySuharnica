package com.zakdroid.candysuharnica.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zakdroid.candysuharnica.data.db.dao.BasketDao
import com.zakdroid.candysuharnica.data.db.dao.CatalogDao
import com.zakdroid.candysuharnica.data.db.dao.UserDao
import com.zakdroid.candysuharnica.data.db.entity.BasketDbEntity
import com.zakdroid.candysuharnica.data.db.entity.CatalogItemDbEntity
import com.zakdroid.candysuharnica.data.db.entity.UserItemDbEntity


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

