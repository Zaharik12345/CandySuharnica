package com.zakdroid.candysuharnica.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.zakdroid.candysuharnica.databinding.ActivityMainBinding
import com.zakdroid.candysuharnica.ui.main.viewModels.CatalogViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CatalogViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)


        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavView.setupWithNavController(navController)

    }
}