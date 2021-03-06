package com.zakdroid.candysuharnica.model.dbRoom.basket

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
    fun getAmountPrice() : Double

    @Query("SELECT * FROM basket WHERE name LIKE :query")
    fun getListFromQuery(query: String): List<BasketDbEntity>

    @Query("SELECT * FROM basket WHERE product_id = :id")
    fun getItemFromId(id: Int) : BasketDbEntity?

    @Query("SELECT count FROM basket WHERE product_id = :id")
    fun getCountFromId(id: Int) : Int

    @Insert
    fun insert(item: BasketDbEntity)

    @Update
    fun update(item: BasketDbEntity)

    @Delete
    fun delete(item: BasketDbEntity)
}