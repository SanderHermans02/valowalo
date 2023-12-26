package com.example.valowalo.ui.agentsScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AgentsScreen(vm: AgentsViewModel = viewModel()) {
    Text(text = "Agents")
}
