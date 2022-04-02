package com.zakdroid.candysuharnica.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zakdroid.candysuharnica.screens.basket.BasketFragmentCompose
import com.zakdroid.candysuharnica.screens.catalog.CatalogFragmentCompose
import com.zakdroid.candysuharnica.screens.profile.ProfileFragmentCompose

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Catalog.route
    ){
        composable(route = BottomBarScreen.Catalog.route){
           CatalogFragmentCompose()
       }
        composable(route = BottomBarScreen.Basket.route){
            BasketFragmentCompose()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileFragmentCompose()
        }
    }
}