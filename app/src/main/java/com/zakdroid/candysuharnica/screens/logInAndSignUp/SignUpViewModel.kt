package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.lifecycle.ViewModel
import com.zakdroid.candysuharnica.data.repository.AuthRepository

class SignUpViewModel(
    val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {
}