package com.iris.gratitudejournal.models

import android.content.Context

interface JournalDataSource {
    fun getJournalEntries(context: Context): List<JournalEntry>
}