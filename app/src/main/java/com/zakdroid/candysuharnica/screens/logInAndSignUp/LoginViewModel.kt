package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private lateinit var navController: NavController

    fun login(username: String, password: String) {
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val direction = LoginFragmentDirections.actionProfileFragmentToProfileFragment1()
                navController.navigate(direction)
            } else {

            }
        }

    }
    fun goToSignUp(){
        val direction =LoginFragmentDirections.actionProfileFragmentToSignUpFragment()
        navController.navigate(direction)
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }
}