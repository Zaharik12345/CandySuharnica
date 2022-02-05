package com.zakdroid.candysuharnica.data.dbRoom.catalog

import androidx.room.*

@Dao
interface CatalogDao {

    @Query("SELECT * FROM catalog")
    fun getAll(): List<CatalogItemDbEntity>

    @Query("DELETE FROM catalog")
    fun deleteTable()

    @Insert
    fun insert(item: CatalogItemDbEntity)

    @Update
    fun update(item: CatalogItemDbEntity)

    @Delete
    fun delete(item: CatalogItemDbEntity)
}