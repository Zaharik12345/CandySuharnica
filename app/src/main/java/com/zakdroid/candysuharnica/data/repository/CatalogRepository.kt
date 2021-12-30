package com.zakdroid.candysuharnica.data.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.zakdroid.candysuharnica.data.FirebaseCallback
import com.zakdroid.candysuharnica.data.model.CatalogItem
import com.zakdroid.candysuharnica.data.model.CatalogResponse
import kotlinx.coroutines.tasks.await

class CatalogRepository constructor(
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val productRef: DatabaseReference = rootRef.child("catalog")
) {
    fun getResponseFromRealtimeDatabaseUsingCallback(callback: FirebaseCallback) {
        productRef.get().addOnCompleteListener { task ->
            val response = CatalogResponse()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.catalogItems = result.children.map { snapShot ->
                        snapShot.getValue(CatalogItem::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            callback.onResponseCatalogItems(response)
        }
    }

    fun getResponseFromRealtimeDatabaseUsingLiveData() : MutableLiveData<CatalogResponse> {
        val mutableLiveData = MutableLiveData<CatalogResponse>()
        productRef.get().addOnCompleteListener { task ->
            val response = CatalogResponse()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.catalogItems = result.children.map { snapShot ->
                        snapShot.getValue(CatalogItem::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            mutableLiveData.value = response
        }
        return mutableLiveData
    }

    suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): CatalogResponse {
        val response = CatalogResponse()
        try {
            response.catalogItems = productRef.get().await().children.map { snapShot ->
                snapShot.getValue(CatalogItem::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }
}