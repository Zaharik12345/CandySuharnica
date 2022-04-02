package com.zakdroid.candysuharnica.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
    ){
    object Catalog: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Lock
    )
    object Basket: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.ShoppingCart
    )
    object Profile: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Person
    )
}