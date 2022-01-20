package com.zakdroid.candysuharnica.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zakdroid.candysuharnica.data.db.dao.*
import com.zakdroid.candysuharnica.data.db.entity.*


@Database(
    version = 1,
    entities = [
        CatalogItemDbEntity::class,
        UserItemDbEntity::class,
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun catalogDao(): CatalogDao

    abstract fun userDao(): UserDao
}
