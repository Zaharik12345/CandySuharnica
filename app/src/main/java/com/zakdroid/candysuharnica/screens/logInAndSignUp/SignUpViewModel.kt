package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel() : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var navController: NavController

    fun register(email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    val direction = SignUpFragmentDirections.actionSignUpFragmentToProfileFragment()
                    navController.navigate(direction)
                }

            }
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun goToSignIn(){
        val directions = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
        navController.navigate(directions)
    }

}