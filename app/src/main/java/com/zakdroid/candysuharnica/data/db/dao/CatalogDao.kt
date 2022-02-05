package com.zakdroid.candysuharnica.data.db.dao

import androidx.room.*
import com.zakdroid.candysuharnica.data.db.entity.CatalogItemDbEntity

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