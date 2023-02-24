package com.example.runningapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.koin.core.module.Module
import org.koin.dsl.module

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val module = module {

        }
    }
}