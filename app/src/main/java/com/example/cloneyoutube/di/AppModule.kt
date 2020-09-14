package com.example.cloneyoutube.di

import jsynctech.com.dhinternalapp.di.repositoryModule
import jsynctech.com.dhinternalapp.di.viewModelModule
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { androidApplication().resources }
}

val appModules = listOf(appModule, viewModelModule,repositoryModule,databaseModule,networkModule)