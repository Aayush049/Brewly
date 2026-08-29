package com.androidlearning.brewly.forntend.screens.detailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.forntend.theme.CharcoalGray
import com.androidlearning.brewly.forntend.theme.LightBrown

@Composable
fun SelectSizeChip(
    sizeText: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            // Changes background based on whether the size is selected.
            .background(
                color = if (isSelected) Color(0xFFF7F0EB) else Color(0xFFFDFDFD),
                RoundedCornerShape(12.dp)
            )
            // Changes border color based on selection state.
            .border(
                1.dp,
                color = if (isSelected) Color(0xFFC67C4E) else Color(0xFFE1E1E1),
                shape = RoundedCornerShape(12.dp)
            )
            .height(46.dp)
            .clickable { onClick() }, // Updates the selected size.
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sizeText,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            // Selected and unselected sizes use different text colors.
            color = if (isSelected) LightBrown else CharcoalGray
        )
    }
}