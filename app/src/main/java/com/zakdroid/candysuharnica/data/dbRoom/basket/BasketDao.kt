package com.zakdroid.candysuharnica.data.dbRoom.basket

import androidx.room.*

@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")
    fun getAll(): List<BasketDbEntity>

    @Query("DELETE FROM basket")
    fun deleteTable()

    @Query("SELECT SUM(count) FROM basket")
    fun getCount() : Int

    @Query("SELECT SUM(price_sum) FROM basket")
    fun getAmountPrice() : Int

    @Insert
    fun insert(item: BasketDbEntity)

    @Update
    fun update(item: BasketDbEntity)

    @Delete
    fun delete(item: BasketDbEntity)
}