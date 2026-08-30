package com.androidlearning.brewly.forntend.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.domain.model.Product
import com.androidlearning.brewly.forntend.theme.LightBrown
import com.androidlearning.brewly.forntend.ui_components.MyBottomNavBar

@Composable
fun CartScreen() {
    val products = listOf(
        Product(id = 1, name = "Espresso", description = "Strong and rich", price = 3.80, imageRes = R.drawable.coffee_2),
        Product(id = 2, name = "Latte", description = "Smooth and creamy", price = 4.50, imageRes = R.drawable.coffee_3),
        Product(id = 3, name = "Cappuccino", description = "With chocolate", price = 4.20, imageRes = R.drawable.coffee_1)
    )

    var amount by remember { mutableDoubleStateOf(12.50) }
    var deliverFee by remember { mutableDoubleStateOf(1.00) }
    var totalAmount by remember { mutableDoubleStateOf(amount + deliverFee) }

    Scaffold(
        topBar = { CartTopAppBar() },
        bottomBar = { MyBottomNavBar() }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row() {
                    Text(
                        text = "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                products.forEach { cartProduct ->
                    CartItemCard(cartProduct)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Payment Summary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                        , fontSize = 20.sp
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Price",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$ $amount",
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery Fee",
                        fontSize = 18.sp
                    )
                    Text(
                        text = "$ $deliverFee",
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCard(totalAmount)
            }
        }
    }
}