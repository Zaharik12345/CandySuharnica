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

}
