package com.zakdroid.candysuharnica.model.dbRoom.user

import androidx.room.*
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItemDbEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun signIn(): List<UserDbEntity>

    @Query("SELECT name FROM user")
    fun getFullName(): String

    @Insert()
    fun signUp(user:UserDbEntity)

    @Query("DELETE FROM user")
    fun deleteUser()

    /*@Query("SELECT likes_id FROM user")
    fun getLikedList(): List<Int>*/

    @Update
    fun update(user: UserDbEntity)
}