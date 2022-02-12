package com.zakdroid.candysuharnica.model.dbRoom.user

import androidx.room.*
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity

@Dao
interface UserDao{
    @Query("SELECT * FROM catalog")
    fun getAll(): List<UserItemDbEntity>

    @Query("DELETE FROM catalog")
    fun deleteTable()

    @Query("SELECT * FROM catalog WHERE type LIKE :type AND name LIKE :query")
    fun getFromTypeAndSearch(type:String,query: String) : List<CatalogItemDbEntity>

    @Insert
    fun insert(item: CatalogItemDbEntity)

    @Update
    fun update(item: CatalogItemDbEntity)

    @Delete
    fun delete(item: CatalogItemDbEntity)
}