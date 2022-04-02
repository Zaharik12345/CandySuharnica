package com.zakdroid.candysuharnica.screens.composeUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SearchBar(){
Card(modifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()
    .padding(4.dp),
     shape = RoundedCornerShape(4.dp),
     border = BorderStroke(1.dp, Color.Black)) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text("AB CDE", fontWeight = FontWeight.W700)
        Text("+0 12345678")
        Text("XYZ city.", color = Color.Gray)
    }
}

}

@Preview
@Composable
fun Example() {
    NormalTextField(label = "Поиск") {
        Icon(
            //modifier = Modifier.padding(1.dp),
            imageVector = Icons.Outlined.Search,
            contentDescription = "Search",
            tint = Color.Black
        )
    }
}

@Composable
fun NormalTextField(
    label: String,
    Icon: @Composable (() -> Unit)
) {

    val (text, setText) = mutableStateOf("")
    Column() {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                modifier = Modifier
                    .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                    .weight(1f),
                leadingIcon = Icon,
                value = text,
                onValueChange = setText,
                label = { Text(text = label, color = Color.Black) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Black,
                    backgroundColor = Color.White
                )
            )
            Image(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(4.dp)),
                imageVector = Icons.Outlined.Clear, contentDescription = null
            )
        }
        Divider(color = Color.Black, thickness = 2.dp)
    }

}

@Preview
@Composable
fun MainScreen(){

    Scaffold() {
        NormalTextField(label = "Search") {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Black
            )
        }
    }
}