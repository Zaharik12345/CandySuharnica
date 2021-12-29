/*
package com.zakdroid.candysuharnica.data.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CatalogRepository (
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val productRef: DatabaseReference = rootRef.child("products")
    ){
        fun getResponseFromRealtimeDatabaseUsingCallback(callback: FirebaseCallback) {
            productRef.get().addOnCompleteListener { task ->
                val response = Response()
                if (task.isSuccessful) {
                    val result = task.result
                    result?.let {
                        response.products = result.children.map { snapShot ->
                            snapShot.getValue(Product::class.java)!!
                        }
                    }
                } else {
                    response.exception = task.exception
                }
                callback.onResponse(response)
            }
        }

        fun getResponseFromRealtimeDatabaseUsingLiveData() : MutableLiveData<Response> {
            val mutableLiveData = MutableLiveData<Response>()
            productRef.get().addOnCompleteListener { task ->
                val response = Response()
                if (task.isSuccessful) {
                    val result = task.result
                    result?.let {
                        response.products = result.children.map { snapShot ->
                            snapShot.getValue(Product::class.java)!!
                        }
                    }
                } else {
                    response.exception = task.exception
                }
                mutableLiveData.value = response
            }
            return mutableLiveData
        }

        suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): Response {
            val response = Response()
            try {
                response.products = productRef.get().await().children.map { snapShot ->
                    snapShot.getValue(Product::class.java)!!
                }
            } catch (exception: Exception) {
                response.exception = exception
            }
            return response
        }*/
