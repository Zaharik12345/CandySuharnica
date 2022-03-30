package com.zakdroid.candysuharnica.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.zakdroid.candysuharnica.MainScreen
import com.zakdroid.candysuharnica.databinding.ActivityMainBinding
import com.zakdroid.candysuharnica.screens.catalog.CatalogViewModel
import com.zakdroid.candysuharnica.screens.theme.BottomNavBarTheme


class MainActivity : ComponentActivity() {

    //private lateinit var viewModel: CatalogViewModel

    //private lateinit var binding: ActivityMainBinding
    //private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavBarTheme{
                MainScreen()
            }
        }


/*        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)

        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        binding.bottomNavView.setupWithNavController(navController)*/

    }
}