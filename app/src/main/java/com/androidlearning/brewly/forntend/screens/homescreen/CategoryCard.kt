package com.androidlearning.brewly.forntend.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.forntend.theme.LightBrown
import com.androidlearning.brewly.forntend.theme.LightGray

@Composable
fun CategoryCard(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit,
) {

    // Creates the visual container for a single coffee category.
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(35.dp)

            // NEW CONCEPT — clip()
            // Clips the content to the specified rounded shape.
            .clip(RoundedCornerShape(6.dp))

            // KNOWN CONCEPT — clickable
            // Makes the entire category card respond to user clicks.
            .clickable {
                onSelected()
            }

            // Changes the background depending on whether
            // this category is currently selected.
            .background(
                color =
                    if (isSelected) LightBrown
                    else LightGray.copy(alpha = 0.6f)
            ),

        // Places the category text in the center of the card.
        contentAlignment = Alignment.Center
    ) {

        // Displays the category name.
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,

            // Prevents the category name from occupying multiple lines.
            maxLines = 1,
        )
    }
}