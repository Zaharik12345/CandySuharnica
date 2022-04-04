package com.zakdroid.candysuharnica.screens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.zakdroid.candysuharnica.screens.composeUI.MainScreen2


class MainActivity : ComponentActivity() {

    //private lateinit var viewModel: CatalogViewModel

    //private lateinit var binding: ActivityMainBinding
    //private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen2()
        }

/*        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)

        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavView.setupWithNavController(navController)*/

    }
}