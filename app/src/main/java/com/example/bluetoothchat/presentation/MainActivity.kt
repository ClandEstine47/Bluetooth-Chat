package com.example.bluetoothchat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bluetoothchat.presentation.components.DeviceScreen
import com.example.bluetoothchat.ui.theme.BluetoothChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BluetoothChatTheme {
                val viewModel = hiltViewModel<BluetoothViewModel>()
                val state by viewModel.state.collectAsState()

                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    DeviceScreen(
                        state = state,
                        onStartScan = { viewModel::startScan },
                        onStopScan = { viewModel::stopScan }
                    )
                }
            }
        }
    }
}
