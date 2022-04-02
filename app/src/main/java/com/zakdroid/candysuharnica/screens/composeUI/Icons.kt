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
}
