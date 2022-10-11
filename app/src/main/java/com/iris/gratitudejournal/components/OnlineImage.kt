package com.iris.gratitudejournal.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun OnlineImage(
    source: String?,
    size: Dp,
    isSquare: Boolean? = false,
    onTapAction: (() -> Unit)? = null
) {
    val modifierToAttach = if(isSquare == true){
        Modifier
            .clip(MaterialTheme.shapes.medium)
            .height(size)
            .width(size)
            .clickable {
                if (onTapAction != null) {
                    onTapAction()
                }
            }
    } else {
        Modifier
            .clip(MaterialTheme.shapes.medium)
            .height(size)
            .clickable {
                if (onTapAction != null) {
                    onTapAction()
                }
            }
    }
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(source)
            .crossfade(true)
            .build(),
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifierToAttach
    )
}