package com.example.valowalo;

import android.app.Application
import com.example.valowalo.data.AppContainer
import com.example.valowalo.data.DefaultAppContainer

class ValoWaloApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}
