package com.v2ray.ang.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    // Local state for connecting feedback
    var connecting by remember { mutableStateOf(false) }

    // Reset connecting state when service actually starts or fails to start
    LaunchedEffect(isRunning) {
        if (isRunning || (!isRunning && connecting)) {
            connecting = false
        }
    }

    // Determine button label - three stages: Start → Connecting → Stop
    val buttonLabel = when {
        connecting -> stringResource(R.string.connecting)
        isRunning -> stringResource(R.string.acc_stop)
        else -> stringResource(R.string.acc_start)
    }

    // Button enabled during Start and Stop, disabled only during Connecting
    val buttonEnabled = !connecting

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Application logo at the top
        androidx.compose.foundation.Image(
            painter = painterResource(R.mipmap.ic_launcher_foreground),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


        // Connect button - bigger, round, fancy
        Button(
            onClick = {
                connecting = true
                onAction(MainAction.ToggleService)
            },
            enabled = buttonEnabled,
            shape = RoundedCornerShape(150.dp),
            modifier = Modifier
                .width(260.dp)
                .height(80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = buttonLabel,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Connection status string - no box, just text, clickable
        Text(
            text = displayText,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onAction(MainAction.TestCurrentServer) })
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Footer text
        Text(
            text = stringResource(R.string.made_with_love_for_freedom),
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                fontSize = 12.sp,
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}