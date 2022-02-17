package com.zakdroid.candysuharnica.screens.logInAndSignUp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.model.dbRoom.user.User
import com.zakdroid.candysuharnica.model.dbRoom.user.UserDbEntity

class LoginViewModel : ViewModel() {
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = App.instance?.getDatabase() ?: throw Exception("error")
    private val user = db.userDao().signIn().map { it.toUser() }

    private lateinit var navController: NavController

    init {
        if (user.isNotEmpty()) {
            login(user[0].name, user[0].password,null)
        }
    }

    fun login(username: String, password: String,context: Context?) {
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
            if (it.isSuccessful) {
                //Toast.makeText(context,mAuth.currentUser?.uid.toString(),Toast.LENGTH_LONG).show()
                if (user.isEmpty()) {
                    val createdUser =
                        UserDbEntity.fromUser(User(name = username, password = password))
                    db.userDao().signUp(createdUser)
                }
                val direction = LoginFragmentDirections.actionSignInFragmentToProfileFragment()
                navController.navigate(direction)
            } else {
                Toast.makeText(context,"Почта или пароль введены неверно!",Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun goToSignUp() {
        val direction = LoginFragmentDirections.actionSignInFragmentToSignUpFragment()
        navController.navigate(direction)
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }
}