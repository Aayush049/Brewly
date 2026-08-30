package com.androidlearning.brewly.forntend.screens.cartscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidlearning.brewly.R
import com.androidlearning.brewly.forntend.theme.LightBrown
import com.androidlearning.brewly.forntend.theme.LightGray

@Composable
fun PaymentModeSelectionCard(totalAmount: Double) {
    var expended by remember { mutableStateOf(false) }

    var selectedMode by remember { mutableStateOf("Online") }

    val paymentModes = listOf(
        "Online",
        "Cash"
    )

    //bottom Card Ui
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            if (selectedMode == "Online") { R.drawable.mobile_banking }
                            else { R.drawable.wallet }
                        ),
                        contentDescription = selectedMode,
                        modifier = Modifier
                            .size(30.dp),
                        tint = LightBrown
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column() {
                        Text(
                            text = selectedMode,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        if (selectedMode == "Online") {
                            Text(
                                text = "$ $totalAmount",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = LightBrown
                                )
                            )
                        }
                        else {
                            Text(
                                text = "$ ${totalAmount + 1.0}",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = LightBrown
                                )
                            )
                        }
                    }

                }
                Box() {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_down),
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable{ expended = !expended }
                    )

                    DropdownMenu(
                        expanded = expended,
                        onDismissRequest = { expended = false },
                        modifier = Modifier
                            .background(
                                color = Color.White
                            ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        paymentModes.forEach { mode ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = mode,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {
                                    selectedMode = mode
                                    expended = false
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            if (mode == "Online") {
                                                R.drawable.mobile_banking
                                            } else {
                                                R.drawable.wallet
                                            }
                                        ),
                                        contentDescription = mode,
                                        tint = LightBrown,
                                        modifier = Modifier
                                            .size(24.dp)
                                    )
                                },
                                modifier = Modifier
                                    .padding(horizontal = 6.dp, vertical = 4.dp)
                                    .background(
                                        color =
                                            if (selectedMode == mode) LightBrown.copy(alpha = 0.1f)
                                            else Color.Transparent,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                ),

                shape = RoundedCornerShape(12.dp)
            ) {

                Text(
                    text = "Place Order",
                    fontSize = 18.sp
                )
            }
        }
    }
}