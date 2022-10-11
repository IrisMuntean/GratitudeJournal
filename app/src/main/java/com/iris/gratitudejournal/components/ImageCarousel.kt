package com.iris.gratitudejournal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImageCarousel(
    imageList: List<String>
){
    var coverPhoto by remember { mutableStateOf(imageList[0]) }
    OnlineImage(
        source = coverPhoto,
        size = 200.dp
    )
    if(imageList.size > 1){
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(imageList) { photo ->
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    OnlineImage(
                        source = photo,
                        size = 100.dp,
                        isSquare = true,
                        onTapAction = {
                            coverPhoto = photo
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (coverPhoto == photo) {
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(5.dp)
                                .background(
                                    color = MaterialTheme.colors.secondary,
                                    shape = MaterialTheme.shapes.medium
                                )
                        )
                    }
                }
            }
        }
    }
}