package com.v2ray.ang.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.v2ray.ang.R
import com.v2ray.ang.ui.compose.LocalDarkTheme

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onAction: (MainAction) -> Unit,
    onNavigate: (MainDestination) -> Unit,
) {
    val uiState = mainViewModel.uiState.collectAsStateWithLifecycle()
    val displayText = mainViewModel.formatStatus(uiState.value.status)
    val isRunning = uiState.value.isRunning

    // Center everything in the screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Connect button - primary action
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(48.dp),
            onClick = { onAction(MainAction.ToggleService) },
            enabled = true
        ) {
            Text(
                text = stringResource(if (isRunning) R.string.acc_stop else R.string.acc_start),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Clickable connection status string - always visible and clickable
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(32.dp)
                .clickable(onClick = { onAction(MainAction.TestCurrentServer) }),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 0.dp
        ) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}