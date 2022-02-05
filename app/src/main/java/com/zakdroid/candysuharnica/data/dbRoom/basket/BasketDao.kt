package com.zakdroid.candysuharnica.data.dbRoom.basket

import androidx.room.*

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