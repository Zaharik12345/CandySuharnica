package com.zakdroid.candysuharnica.screens.composeUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SearchBar(){

Card(modifier = Modifier
    .fillMaxWidth()
    .padding(4.dp)
    .wrapContentHeight(),
     shape = RoundedCornerShape(4.dp),
     border = BorderStroke(2.dp, Color.Black)) {
    Row(modifier = Modifier.padding(10.dp)) {
        //Icon(bitmap = Icons.Search.image , contentDescription = Icons.Search.description)
    }
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

        }
        Divider(color = Color.Black, thickness = 2.dp)
    }

}

@Preview
@Composable
fun MainScreen(){

    Scaffold {
        SearchBar()
        SearchBar()
    }
}