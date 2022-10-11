package com.iris.gratitudejournal.viewModels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iris.gratitudejournal.data.JournalEntriesRepository
import com.iris.gratitudejournal.models.JournalState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JournalViewModel(
    context: Context,
    repository: JournalEntriesRepository
) : ViewModel() {

    var journalState = mutableStateOf(JournalState())
        private set

    init {
        viewModelScope.launch {
            journalState.value = journalState.value.copy(isLoading = true)
            delay(5000L)
            journalState.value = journalState.value.copy(
                isLoading = false,
                journalEntries = repository.allJournalEntries(context)
            )

        }
    }
}