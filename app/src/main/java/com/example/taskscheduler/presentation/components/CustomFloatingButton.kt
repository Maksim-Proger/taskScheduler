package com.example.taskscheduler.presentation.components

import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomFloatingButton(
    imageIcon: ImageVector,
    contentDescription: String,
    textFloatingButton: String,
    expanded: Boolean,
    onButtonClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = onButtonClick,
        icon = {
            Icon(
                imageVector = imageIcon,
                contentDescription = contentDescription
            )
        },
        text = {
            Text(
                text = textFloatingButton,
                style = MaterialTheme.typography.bodyLarge)
        },
        expanded = expanded,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}