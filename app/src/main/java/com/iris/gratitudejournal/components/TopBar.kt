package com.iris.gratitudejournal.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    backNavigationEnabled: Boolean? = false,
    onNavigate: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        if (backNavigationEnabled == true) {
            IconButton(
                onClick = {
                    if (onNavigate != null) {
                        onNavigate()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = "Back"
                )
            }
        }
        Text(
            text = title,
            color = MaterialTheme.colors.primary,
            style = if (backNavigationEnabled == true) MaterialTheme.typography.body1 else MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(top = (if (backNavigationEnabled == true) 0.dp else 25.dp))
                .fillMaxWidth()
        )
    }
}