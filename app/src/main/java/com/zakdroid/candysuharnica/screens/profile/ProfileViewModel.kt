package com.zakdroid.candysuharnica.screens.profile

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.AppDatabase

class ProfileViewModel:ViewModel() {

    private val db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    private lateinit var navController: NavController

    fun exit() {
        db.userDao().deleteUser()
        val direction = ProfileFragmentDirections.actionProfileFragmentToSignInFragment()
        navController.navigate(direction)
    }

    fun setNavController(findNavController: NavController) {
        navController = findNavController
    }
}