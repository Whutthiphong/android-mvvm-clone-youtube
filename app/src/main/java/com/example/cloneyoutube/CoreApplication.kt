package com.example.cloneyoutube

import android.app.Application
import com.example.cloneyoutube.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoreApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CoreApplication)
            modules(appModules)
        }
    }
}
