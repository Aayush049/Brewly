package com.androidlearning.brewly.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.ui.theme.LightBrown

@Composable
fun SearchBar() {

    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text( text = "Search Coffee", color = Color.LightGray ) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.regular_outline_search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.White
                )
            },
            shape = RoundedCornerShape(
                topStart = 16.dp,
                bottomStart = 16.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp
            ),
            singleLine = true, //to limit the number of lines
            modifier = Modifier
                .weight(1f)
                .size(58.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedContainerColor = Color(0xFF422A24),
                cursorColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.width(5.dp))

        IconButton(
            onClick = { /* Handle search button click */ },
            modifier = Modifier
                .size(width = 50.dp, height = 58.dp)
                .background(
                    color = LightBrown,
                    shape = RoundedCornerShape(topEnd = 16.dp,
                        bottomEnd = 16.dp,
                        topStart = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.regular_outline_filter),
                contentDescription = "Filter",
                tint = Color.White
            )
        }
    }
}