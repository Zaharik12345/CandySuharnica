package com.zakdroid.candysuharnica.data.db.dao

import androidx.room.*
import com.zakdroid.candysuharnica.data.db.entity.BasketDbEntity

@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")

    fun getAll(): List<BasketDbEntity>

    @Insert
    fun insert(car: BasketDbEntity)

    @Update
    fun update(car: BasketDbEntity)

    @Delete
    fun delete(car: BasketDbEntity)
}