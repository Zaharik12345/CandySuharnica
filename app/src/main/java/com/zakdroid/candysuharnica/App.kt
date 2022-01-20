package com.zakdroid.candysuharnica

import android.app.Application
import androidx.room.Room
import com.zakdroid.candysuharnica.data.db.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    fun getDatabase() = database

    companion object {
        var instance: App? = null
    }
}