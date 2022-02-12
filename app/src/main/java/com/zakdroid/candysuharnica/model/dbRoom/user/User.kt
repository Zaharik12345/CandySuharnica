package com.zakdroid.candysuharnica.model.dbRoom.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int = 0,
    val name: String = "",
    val password: String = "",
    val mobile_number: String = "",
    val address: String = ""
):Parcelable
