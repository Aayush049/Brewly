package com.androidlearning.brewly.forntend.ui_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AppMessageDialog(
    show: Boolean,
    title: String,
    message: String,
    onDismiss: () -> Unit
) {

    // Shows the dialog only when show is true.
    if (show) {
        AlertDialog(
            // Called when the user dismisses the dialog.
            onDismissRequest = { onDismiss() },

            title = {
                Text(text = title)
            },

            text = {
                Text(text = message)
            },

            // OK button closes the dialog.
            confirmButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}