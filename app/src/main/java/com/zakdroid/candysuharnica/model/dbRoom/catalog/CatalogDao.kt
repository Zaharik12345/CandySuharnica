package com.zakdroid.candysuharnica.model.dbRoom.catalog

import androidx.room.*
import com.zakdroid.candysuharnica.model.dbRoom.user.UserItemDbEntity

@Dao
interface CatalogDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserItemDbEntity>

    @Query("DELETE FROM user")
    fun deleteTable()

    @Insert
    fun insert(item: UserItemDbEntity)

    @Update
    fun update(item: UserItemDbEntity)

    @Delete
    fun delete(item: UserItemDbEntity)
}