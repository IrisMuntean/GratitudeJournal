package com.iris.gratitudejournal.data

import android.content.Context
import com.iris.gratitudejournal.models.JournalEntry

interface JournalDataSource {
    fun getJournalEntries(context: Context): List<JournalEntry>
}