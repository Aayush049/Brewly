package com.androidlearning.brewly.forntend.screens.favouritescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.theme.LightBrown
import com.androidlearning.brewly.forntend.theme.LightGray

@Composable
fun FavouriteItemCard(favouriteProduct: Product, onRemove: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = favouriteProduct.imageRes),
                contentDescription = favouriteProduct.name,
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = favouriteProduct.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = favouriteProduct.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconButton(
                    onClick = onRemove,
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(alpha = 0.1f),
                            shape = CircleShape
                        )
                        .size(36.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove From Favourites",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}