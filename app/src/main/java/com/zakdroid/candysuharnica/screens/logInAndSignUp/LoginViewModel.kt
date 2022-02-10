package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.zakdroid.candysuharnica.data.repository.AuthRepository

class LoginViewModel(
    val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {
}