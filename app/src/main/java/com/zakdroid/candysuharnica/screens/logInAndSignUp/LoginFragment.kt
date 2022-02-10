package com.zakdroid.candysuharnica.screens.logInAndSignUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.zakdroid.candysuharnica.R

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

        return inflater.inflate(R.layout.fragment_login,container,false)
    }

}