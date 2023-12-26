package com.example.valowalo.ui.rouletteScreen

import android.util.Log
import androidx.lifecycle.ViewModel
class RouletteViewModel : ViewModel() {
    init {
        Log.i("vm inspection", "RouletteViewModel init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("vm inspection", "RouletteViewModel cleared")
    }
}
