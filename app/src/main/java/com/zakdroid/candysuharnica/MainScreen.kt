package com.zakdroid.candysuharnica

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zakdroid.candysuharnica.screens.BottomBarScreen
import com.zakdroid.candysuharnica.screens.BottomNavGraph


@Composable
fun MainScreen()
{
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController)}) {
        BottomNavGraph(navController =  navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Catalog,
        BottomBarScreen.Basket,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation{
        screens.forEach{ screen->
            AddItem(screen, currentDestination, navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        }==true,
        onClick = {navController.navigate(screen.route)}
    )
}