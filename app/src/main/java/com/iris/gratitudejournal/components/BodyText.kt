package com.iris.gratitudejournal.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun BodyText(
    text: String
){
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary
    )
}
