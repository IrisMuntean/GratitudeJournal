package com.iris.gratitudejournal.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iris.gratitudejournal.models.JournalDataSource
import com.iris.gratitudejournal.models.JournalEntry
import java.io.IOException

class LocalJournalSource : JournalDataSource {
    private val gson = Gson()
    private val journalListType = object : TypeToken<List<JournalEntry>>() {}.type

    override fun getJournalEntries(context: Context): List<JournalEntry> {
        val jsonString = getJsonDataFromAsset(context)
        return gson.fromJson(jsonString, journalListType)
    }

    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(jsonFile).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    companion object Constants {
        const val jsonFile: String = "journalData.json"
    }
}