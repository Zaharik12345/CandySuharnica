package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(username: String, password: String):Boolean {
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val direction = LoginFragmentDirections.actionProfileFragmentToProfileFragment1()

            } else {

            }
        }

    }
}