package com.iris.gratitudejournal.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iris.gratitudejournal.components.BodyText
import com.iris.gratitudejournal.components.OnlineImage
import com.iris.gratitudejournal.components.Subtext
import com.iris.gratitudejournal.components.TopBar
import com.iris.gratitudejournal.helpers.DateHelper
import com.iris.gratitudejournal.models.JournalEntry
import com.iris.gratitudejournal.viewModels.JournalViewModel

@Composable
fun ListScreen(
    onNavigateToDetails: (itemId: String) -> Unit,
    journalViewModel: JournalViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            title = stringResource(id = com.iris.gratitudejournal.R.string.daily_gratitude)
        )
        journalViewModel.journalState.value.journalEntries.let {
            LazyColumn {
                items(it) { journalEntry ->
                    JournalCard(
                        journalEntry = journalEntry,
                        onItemTap = onNavigateToDetails
                    )
                }
            }
        }
        if (journalViewModel.journalState.value.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun JournalCard(
    journalEntry: JournalEntry,
    onItemTap: (itemId: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
            .clickable { onItemTap(journalEntry.id) },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Subtext(text = DateHelper.dateToString(journalEntry.date))
            BodyText(text = journalEntry.summary)
            if (!journalEntry.coverPhoto.isNullOrEmpty()) {
                OnlineImage(source = journalEntry.coverPhoto, size = 200.dp)
            }
        }
    }
}
