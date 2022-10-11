package com.iris.gratitudejournal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iris.gratitudejournal.components.*
import com.iris.gratitudejournal.helpers.DateHelper
import com.iris.gratitudejournal.models.JournalEntry

@Composable
fun DetailsScreen(
    navController: NavController,
    journalEntry: JournalEntry
) {
    var imageList: MutableList<String> = mutableListOf()
    if(journalEntry.otherPhotos.isNullOrEmpty()){
        if(!journalEntry.coverPhoto.isNullOrEmpty()){
            imageList = mutableListOf(journalEntry.coverPhoto)
        }
    } else {
        imageList = journalEntry.otherPhotos.toMutableList()
        journalEntry.coverPhoto?.let { imageList.add(0, it) }
    }

    Column(
        modifier = Modifier.background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TopBar(
            title = journalEntry.id,
            backNavigationEnabled = true,
            onNavigate = { navController.navigateUp() }
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Subtext(text = DateHelper.dateToString(journalEntry.date))
        BodyText(text = journalEntry.summary)
        if(imageList.isNotEmpty()) {
            ImageCarousel(imageList = imageList.toList())
        }
        journalEntry.tags?.let {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(it) { tag ->
                    Tag(text = tag)
                }
            }
        }
    }
}