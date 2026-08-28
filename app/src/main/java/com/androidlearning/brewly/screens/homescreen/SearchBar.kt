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

    // KNOWN CONCEPT — State
    // Stores the text currently entered into the search field.
    // The state is local because only SearchBar needs this value right now.
    var searchText by remember { mutableStateOf("") }

    // Places the search field and filter button horizontally.
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // NEW CONCEPT — TextField
        // Material 3 input component used to allow the user to enter search text.
        TextField(
            // Current text displayed inside the TextField.
            value = searchText,

            // Called whenever the user changes the text.
            // Updates searchText with the new value.
            onValueChange = { searchText = it },

            // Text displayed when the search field is empty.
            placeholder = {
                Text(
                    text = "Search Coffee",
                    color = Color.LightGray
                )
            },

            // Adds the search icon to the beginning of the TextField.
            leadingIcon = {
                Icon(
                    painter = painterResource(
                        id = R.drawable.regular_outline_search
                    ),
                    contentDescription = "Search",
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.White
                )
            },

            // Gives the TextField rounded corners only on the left side.
            // The right side is kept square because the filter button
            // is placed directly beside it.
            shape = RoundedCornerShape(
                topStart = 16.dp,
                bottomStart = 16.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp
            ),

            // NEW CONCEPT — singleLine
            // Restricts the TextField to a single line of text.
            singleLine = true,

            modifier = Modifier
                // Allows the TextField to take the remaining horizontal space.
                .weight(1f)

                // Sets the height of the TextField.
                .size(58.dp),

            // NEW CONCEPT — TextFieldDefaults.colors
            // Customizes the appearance of the Material 3 TextField.
            colors = TextFieldDefaults.colors(

                // Removes the indicator line when the TextField is focused.
                focusedIndicatorColor = Color.Transparent,

                // Removes the indicator line when the TextField is not focused.
                unfocusedIndicatorColor = Color.Transparent,

                // Background color when the TextField is not focused.
                unfocusedContainerColor = Color(0xFF2A2A2A),

                // Background color when the TextField is focused.
                focusedContainerColor = Color(0xFF422A24),

                // Color of the cursor while typing.
                cursorColor = Color.LightGray,

                // Color of text while the TextField is focused.
                focusedTextColor = Color.White,

                // Color of text while the TextField is not focused.
                unfocusedTextColor = Color.Gray
            )
        )

        // Adds a small gap between the TextField and filter button.
        Spacer(modifier = Modifier.width(5.dp))

        // NEW CONCEPT — IconButton
        // Provides a clickable button designed specifically for an icon.
        IconButton(
            onClick = { /* Handle search button click */ },

            modifier = Modifier
                .size(
                    width = 50.dp,
                    height = 58.dp
                )

                // Gives the filter button its background color
                // and rounds only the right-side corners.
                .background(
                    color = LightBrown,
                    shape = RoundedCornerShape(
                        topEnd = 16.dp,
                        bottomEnd = 16.dp,
                        topStart = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {

            // Filter icon added to the right side of the search bar.
            Icon(
                painter = painterResource(
                    id = R.drawable.regular_outline_filter
                ),
                contentDescription = "Filter",
                tint = Color.White
            )
        }
    }
}