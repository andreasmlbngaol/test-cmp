package com.sanalab.publicclass

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
data object AuthRoute

@Serializable
data object HomeRoute

@Serializable
data object CashierRoute

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AuthRoute
    ) {
        composable<AuthRoute> {
            Scaffold { paddingValues ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Hello from Fanfare",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = "Welcome to the Fanfare API! This domain is leading you to the API documentation.",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    var showText by remember { mutableStateOf(false) }
                    Button(
                        onClick = {
                            showText = !showText
                        }
                    ) {
                        Text("This is just a button")
                    }
                    AnimatedVisibility(showText) {
                        Text("This text is visible when the button is clicked")
                    }
                }
            }
        }
    }
}