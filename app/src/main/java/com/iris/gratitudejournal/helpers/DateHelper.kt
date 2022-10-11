package com.iris.gratitudejournal.helpers

import android.util.Log
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    companion object {
        fun dateToString(date: Date): String {
            val formatter: DateFormat = SimpleDateFormat("EEEE, MMMM d, yyyy")
            return formatter.format(date)
        }
    }
}