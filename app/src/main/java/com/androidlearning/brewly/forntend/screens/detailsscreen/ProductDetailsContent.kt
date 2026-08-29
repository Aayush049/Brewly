package com.androidlearning.brewly.forntend.screens.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.theme.IvoryWhite
import com.androidlearning.brewly.forntend.theme.LightGray

@Composable
fun ProductDetailsContent(
    product: Product,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding)
    ) {

        // Displays the selected coffee's image.
        Image(
            painter = painterResource(product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Displays the coffee name.
        Text(
            text = product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(
                text = "Ice / Hot",
                fontSize = 16.sp,
                color = LightGray,
                fontWeight = FontWeight.Medium
            )

            // Coffee bean icon added beside the temperature option.
            Icon(
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "Bean",
                modifier = Modifier
                    .background(
                        color = IvoryWhite,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(35.dp)
                    .padding(start = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Separates the basic product information from the description.
        HorizontalDivider(
            color = Color.LightGray.copy(alpha = 0.5f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Displays the selected coffee's description.
        Text(
            text = product.description,
            fontSize = 16.sp,
            color = LightGray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Size",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        // State keeps track of the currently selected coffee size.
        var selectedSizeText by remember { mutableStateOf("S") }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            // Creates a chip for each available coffee size.
            listOf("S", "M", "L").forEach { size ->
                SelectSizeChip(
                    sizeText = size,
                    isSelected = size == selectedSizeText,
                    onClick = { selectedSizeText = size },
                    modifier = Modifier
                        .weight(1f)
                        .height(46.dp)
                )
            }
        }
    }
}