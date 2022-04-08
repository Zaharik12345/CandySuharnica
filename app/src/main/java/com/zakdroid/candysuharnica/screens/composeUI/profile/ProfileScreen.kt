package com.zakdroid.candysuharnica.screens.composeUI.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.screens.composeUI.FontGolos.GolosFontFamily
import com.zakdroid.candysuharnica.screens.composeUI.Icons

@Composable
fun Profile(){
    Column {
        Divider(color = Color.Black, thickness = 2.dp)
        topCard()
        Divider(color = Color.Black, thickness = 2.dp)
        someInfo()
        Divider(color = Color.Black, thickness = 2.dp)
        myOrders()
        Divider(color = Color.Black, thickness = 2.dp)
        myFavorites()
        Divider(color = Color.Black, thickness = 2.dp)
    }
}

@Composable
fun topCard(){
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                    painter = painterResource(Icons.Profile.image),
                    contentDescription = "Profile photo",
                    modifier = Modifier
                        .size(width = 100.dp, height = 90.dp)
                )
            Column() {
                Text(text = stringResource(id = R.string.full_name_profile_example),
                    fontFamily = GolosFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                Text(text = stringResource(id = R.string.phone_number_profile_example),
                    fontFamily = GolosFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                Text(text = stringResource(id = R.string.address_profile_example),
                    fontFamily = GolosFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(31.dp)
                ) {
                Icon(
                    painter = painterResource(Icons.Edit.image),
                    contentDescription = "Edit icon")
            }

        }
    }
}

@Composable
fun someInfo(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(){
            Text(text = stringResource(id = R.string.bank_card_number_profile),
                fontFamily = GolosFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
            Text(text = stringResource(id = R.string.amount_example_xx),
                fontFamily = GolosFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(31.dp)
            ) {
                Icon(
                    painter = painterResource(Icons.Edit.image),
                    contentDescription = "Edit icon")
            }
        }
    }
}

@Composable
fun myOrders(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(painter = painterResource(Icons.SmallBasket.image),
                contentDescription = "small basket icon")
            Text(text = stringResource(id = R.string.my_orders_profile),
                fontFamily = GolosFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
            Text(text = stringResource(id = R.string.delivery_text),
                fontFamily = GolosFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
            Text(text = stringResource(id = R.string.delivery_time),
                fontFamily = GolosFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp)
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    painter = painterResource(Icons.SmallPlus.image),
                    contentDescription = "plus icon")
            }
        }
        LazyColumn{

        }
    }
}

@Composable
fun myFavorites() {
    Row(){
        Icon(painter = painterResource(Icons.Smile.image),
            contentDescription = "smile icon")
        Text(text = stringResource(id = R.string.favorites_desserts),
            fontFamily = GolosFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp)
        Text(text = stringResource(id = R.string.amount_example_xx),
            fontFamily = GolosFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp)
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    Profile()
}