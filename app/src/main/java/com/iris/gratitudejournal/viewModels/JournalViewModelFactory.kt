package com.iris.gratitudejournal.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iris.gratitudejournal.data.JournalEntriesRepository

class JournalViewModelFactory(
    private val context: Context,
    private val repository: JournalEntriesRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        JournalViewModel(context, repository) as T
}