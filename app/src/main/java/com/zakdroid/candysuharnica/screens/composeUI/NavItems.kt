package com.zakdroid.candysuharnica.screens.composeUI

import com.zakdroid.candysuharnica.R

sealed class NavItems(
    val name: String, val icon: Int, val title: String
) {
    object Catalog : NavItems("catalog", R.drawable.main_catalog_icon, "catalog")
    object Basket : NavItems("basket", R.drawable.basket_icon, "basket")
    object Profile : NavItems("profile", R.drawable.profile_of_user_icon, "profile")
}

