package com.zakdroid.candysuharnica.screens.composeUI

import androidx.annotation.DrawableRes
import com.zakdroid.candysuharnica.R

sealed class Icons(
    val description: String, @DrawableRes val image: Int
) {
    object Search : Icons(
        "search",
        R.drawable.ic_search
    )

    object Sort : Icons(
        "sort",
        R.drawable.ic_sort
    )

    object Profile : Icons(
        "sort",
        R.drawable.ic_profile
    )

    object Catalog : Icons(
        "sort",
        R.drawable.ic_catalog
    )

    object Basket : Icons(
        "sort",
        R.drawable.ic_basket
    )

    object Edit: Icons(
        "edit",
        R.drawable.edit_icon
    )
    object SmallBasket: Icons(
        "small basket",
        R.drawable.small_basket_icon
    )

    object SmallPlus: Icons(
        "small plus",
        R.drawable.plus_list_icon
    )

    object Smile: Icons(
        "small smile",
        R.drawable.ic_baseline_tag_faces_black
    )

}
