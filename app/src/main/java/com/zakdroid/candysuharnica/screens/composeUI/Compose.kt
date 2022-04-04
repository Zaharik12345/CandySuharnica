package com.zakdroid.candysuharnica.screens.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.screens.composeUI.profile.Profile


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavItems.Catalog,
        NavItems.Basket,
        NavItems.Profile
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                //modifier = Modifier.padding(top = 35.dp),
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                selected = true,

                icon = { Icon( //modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title) },

                onClick = {
                    navController.navigate(item.name) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun CatalogScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchBar()
        Text(
            text = "Catalog",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun BasketScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchBar()
        Text(
            text = "Basket",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.grey))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Profile()
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavItems.Catalog.name) {
        composable(NavItems.Catalog.name) {
            CatalogScreen()
        }
        composable(NavItems.Basket.name) {
            BasketScreen()
        }
        composable(NavItems.Profile.name) {
            ProfileScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreen2() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}
