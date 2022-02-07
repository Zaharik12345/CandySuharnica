package com.zakdroid.candysuharnica.data.dbRoom.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserItem(
    val id: Int = 0,
    val first_name: String = "",
    val second_name: String = "",
    val mobile_number: String = "",
    val address: String = ""
):Parcelable
