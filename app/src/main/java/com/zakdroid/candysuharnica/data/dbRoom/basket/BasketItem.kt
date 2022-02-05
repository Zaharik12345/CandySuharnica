package com.zakdroid.candysuharnica.data.dbRoom.basket

data class BasketItem(
    val id: Int,
    val productId: Int,
    val count: Int,
    val amountPrice: Int
) {
}