package com.zakdroid.candysuharnica.data.db.dao

import androidx.room.*
import com.zakdroid.candysuharnica.data.db.entity.CatalogItemDbEntity

@Dao
interface CatalogDao {

    @Query("SELECT * FROM catalog")

    fun getAll(): List<CatalogItemDbEntity>

    @Insert
    fun insert(car: CatalogItemDbEntity)

    @Update
    fun update(car: CatalogItemDbEntity)

    @Delete
    fun delete(car: CatalogItemDbEntity)
}