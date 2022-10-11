package com.iris.gratitudejournal.models

data class JournalState (
    val isLoading: Boolean = true,
    val journalEntries: List<JournalEntry> = emptyList()
)