package com.gadzhiev.imagesearchapp.presentation.screns.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun ErrorScreen(
    reLoad: () -> Unit,
) {
    Column(
        content = {
            Text(
                text = "Error",
                color = MaterialTheme.colorScheme.error
            )
            Button(onClick = reLoad) {
                Text(text = "Reloading")
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
}