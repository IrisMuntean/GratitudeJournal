package com.iris.gratitudejournal.data

import android.content.Context
import com.iris.gratitudejournal.models.JournalDataSource
import com.iris.gratitudejournal.models.JournalEntry

class JournalEntriesRepository(
    private val journalSource: JournalDataSource
) {
    fun allJournalEntries(context: Context): List<JournalEntry> =
        journalSource.getJournalEntries(context)
}