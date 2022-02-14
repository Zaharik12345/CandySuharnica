package com.zakdroid.candysuharnica.screens.logInAndSignUp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var navController: NavController
    private lateinit var context: Context

    fun register(email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    val direction = SignUpFragmentDirections.actionSignUpFragmentToProfileFragment()
                    navController.navigate(direction)
                }
                else{
                    Toast.makeText(context,"Произошла ошибка",Toast.LENGTH_SHORT).show()
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

    fun setContext(requireContext: Context) {
        context = requireContext
    }

}