package com.zakdroid.candysuharnica.data.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseSource {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val userMutableLiveData = MutableLiveData<FirebaseUser>();


    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {result ->
            if (result.isSuccessful) {
                userMutableLiveData.postValue(firebaseAuth.currentUser)
            }
        }
    }

    fun register(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){

                }
        }
    }

    fun logout() = firebaseAuth.signOut()

    fun currentUser() = firebaseAuth.currentUser
}