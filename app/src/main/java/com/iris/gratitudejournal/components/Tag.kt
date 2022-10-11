package com.iris.gratitudejournal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Tag(
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        color = Color.White,
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.secondary,
                shape = MaterialTheme.shapes.medium
            )
            .padding(8.dp)
    )
}