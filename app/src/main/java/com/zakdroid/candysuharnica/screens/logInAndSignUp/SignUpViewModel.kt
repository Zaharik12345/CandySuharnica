package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel() : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var navController: NavController

    fun register(email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    val direction = LoginFragmentDirections.actionProfileFragmentToProfileFragment1()
                    navController.navigate(direction)
                }

            }
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }
}