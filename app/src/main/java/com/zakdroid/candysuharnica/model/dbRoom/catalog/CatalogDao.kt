package com.zakdroid.candysuharnica.model.dbRoom.catalog

import androidx.room.*

@Dao
interface CatalogDao {

    @Query("SELECT * FROM catalog")
    fun getAll(): List<CatalogItemDbEntity>

    @Query("DELETE FROM catalog")
    fun deleteTable()

    @Query("SELECT * FROM catalog WHERE type LIKE :type AND name LIKE :query")
    fun getFromTypeAndSearch(type:String,query: String) : List<CatalogItemDbEntity>

    @Query("SELECT weight FROM catalog WHERE id = :id")
    fun getWeightFRomId(id: Int) : Int

    @Query("SELECT price FROM catalog WHERE id = :id")
    fun getPriceFRomId(id: Int) : Int

    @Insert
    fun insert(item: CatalogItemDbEntity)

    @Update
    fun update(item: CatalogItemDbEntity)

    @Delete
    fun delete(item: CatalogItemDbEntity)
}