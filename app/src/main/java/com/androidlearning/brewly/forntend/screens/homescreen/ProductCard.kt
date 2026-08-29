package com.androidlearning.brewly.forntend.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.theme.IvoryWhite
import com.androidlearning.brewly.forntend.theme.LightBrown
import com.androidlearning.brewly.forntend.theme.LightGray

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {

    // NEW CONCEPT — Card
    // Material 3 Card used as the main container for one coffee product.
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),

        // Gives the product card rounded corners.
        shape = RoundedCornerShape(16.dp),

        // NEW CONCEPT — CardDefaults.cardColors()
        // Customizes the background color of the Card.
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        )
    ) {

        // Contains all information belonging to this product.
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {

            // Container for the product image and favorite button.
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {

                // Displays the product's image.
                // The image is obtained from the imageRes stored in Product.
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = "Coffee Image",

                    // NEW CONCEPT — ContentScale.Crop
                    // Scales the image so that the entire Box is filled.
                    // Parts of the image may be cropped if the aspect ratio differs.
                    contentScale = ContentScale.Crop,

                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                )

                // APPLICATION — Favorite Button
                // Favorite icon is placed over the top-right corner of the image.
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(
                            color = Color.LightGray.copy(alpha = 0.8f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(
                            horizontal = 6.dp,
                            vertical = 4.dp
                        )
                ) {

                    // Displays the heart icon for the favorite action.
                    // Actual favorite functionality has not been implemented yet.
                    Icon(
                        painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "Add to Favorite",
                        tint = LightBrown,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

            // Space between the image and product name.
            Spacer(modifier = Modifier.height(8.dp))

            // Displays the product name.
            Text(
                text = product.name,

                // NEW CONCEPT — MaterialTheme.typography
                // Uses the application's Material 3 typography style.
                //
                // NEW CONCEPT — copy()
                // Creates a modified version of the existing typography style
                // without changing the original theme definition.
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )

            // Space between the product name and description.
            Spacer(modifier = Modifier.height(4.dp))

            // Displays a short product description.
            Text(
                text = product.description,

                // Uses the application's predefined bodySmall typography style
                // and customizes its color.
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray
                ),

                // Keeps the description limited to one line.
                maxLines = 1,

                // NEW CONCEPT — TextOverflow.Ellipsis
                // Shows "..." when the text does not fit within the available space.
                overflow = TextOverflow.Ellipsis
            )

            // Space between the description and bottom row.
            Spacer(modifier = Modifier.height(8.dp))

            // Bottom row contains the price and Add to Cart button.
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                // Places the price at the start and button at the end.
                horizontalArrangement = Arrangement.SpaceBetween,

                verticalAlignment = Alignment.CenterVertically
            ) {

                // Displays the product price.
                Text(
                    text = "$${product.price}",

                    // Uses the theme's titleMedium typography
                    // and customizes the weight and color.
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                )

                // NEW CONCEPT — IconButton
                // Button designed around an icon for a compact action.
                IconButton(
                    onClick = { /* Handle favorite button click */ },

                    // NEW CONCEPT — IconButtonDefaults.iconButtonColors()
                    // Customizes the button's background and icon colors.
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = LightBrown,
                        contentColor = IvoryWhite
                    ),

                    // Gives the button rounded corners.
                    shape = RoundedCornerShape(10.dp)
                ) {

                    // Add icon represents the Add to Cart action.
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to Cart"
                    )
                }
            }
        }
    }
}