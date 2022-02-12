package com.zakdroid.candysuharnica.model.dbRoom.user

import androidx.room.*
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun signIn(): List<UserDbEntity>

    @Insert()
    fun signUp(user:UserDbEntity)

    @Query("DELETE FROM user")
    fun deleteUser()

}