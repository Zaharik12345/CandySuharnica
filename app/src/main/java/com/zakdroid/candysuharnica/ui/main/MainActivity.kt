package com.zakdroid.candysuharnica.ui.main

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.zakdroid.candysuharnica.data.CatalogRepository
import com.zakdroid.candysuharnica.databinding.ActivityMainBinding
import kotlinx.coroutines.tasks.await


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavView.setupWithNavController(navController)

        //val firebase = FirebaseDatabase.getInstance()
        val database = Firebase.database
        val myRef = database.getReference("candysuharnica-default-rtdb")

        val catalog = myRef.get().await().children.map { snapShot ->
            snapShot.getValue(CatalogRepository::class.java)!!
        }
        //myRef.setValue("Hello, World!")
        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.value
                Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
    }
}