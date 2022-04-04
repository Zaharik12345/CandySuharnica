package com.zakdroid.candysuharnica.screens.composeUI.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    topCard()
}

@Composable
fun topCard(){
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(){
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

@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    Profile()
}