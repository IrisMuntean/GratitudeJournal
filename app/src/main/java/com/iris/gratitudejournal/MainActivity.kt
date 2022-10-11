package com.iris.gratitudejournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iris.gratitudejournal.data.JournalEntriesRepository
import com.iris.gratitudejournal.viewModels.JournalViewModel
import com.iris.gratitudejournal.data.LocalJournalSource
import com.iris.gratitudejournal.screens.DetailsScreen
import com.iris.gratitudejournal.screens.ListScreen
import com.iris.gratitudejournal.ui.theme.GratitudeJournalTheme

class MainActivity : ComponentActivity() {
    private val journalViewModel = JournalViewModel(
        this,
        JournalEntriesRepository(LocalJournalSource())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GratitudeJournalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                            .padding(all = 25.dp)
                    ) {
                        NavHost(navController = navController, startDestination = "list") {
                            composable("list") {
                                ListScreen(
                                    onNavigateToDetails = {
                                        navController.navigate("details/${it}")
                                    },
                                    journalViewModel
                                )
                            }
                            composable(
                                "details/{itemId}",
                                arguments = listOf(navArgument("itemId") {
                                    type = NavType.StringType
                                })
                            ) { backStackEntry ->
                                DetailsScreen(
                                    navController,
                                    journalViewModel.journalState.value.journalEntries.first {
                                        it.id == backStackEntry.arguments?.getString("itemId")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
