package com.zakdroid.candysuharnica.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.zakdroid.candysuharnica.screens.composeUI.MainScreen
import com.zakdroid.candysuharnica.screens.composeUI.MainScreen2


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen2()
        }
    }
}