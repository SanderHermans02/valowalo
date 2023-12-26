package com.example.valowalo.ui.agentsScreen

import android.util.Log
import androidx.lifecycle.ViewModel

class AgentsViewModel : ViewModel() {
    init {
        Log.i("vm inspection", "AgentsViewModel init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("vm inspection", "AgentsViewModel cleared")
    }
}
