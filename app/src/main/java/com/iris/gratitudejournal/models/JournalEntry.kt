package com.iris.gratitudejournal.models

import java.util.Date

data class JournalEntry(
    val id: String,
    val date: Date,
    val summary: String,
    val coverPhoto: String? = null,
    val otherPhotos: List<String>? = null,
    val tags: List<String>? = null
)