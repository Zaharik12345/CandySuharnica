package com.zakdroid.candysuharnica.data.db.dao

import androidx.room.*
import com.zakdroid.candysuharnica.data.db.entity.BasketDbEntity
import com.zakdroid.candysuharnica.data.db.entity.CatalogItemDbEntity

@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")
    fun getAll(): List<BasketDbEntity>

    @Query("DELETE FROM basket")
    fun deleteTable()

    @Insert
    fun insert(item: BasketDbEntity)

    @Update
    fun update(item: BasketDbEntity)

    @Delete
    fun delete(item: BasketDbEntity)
}