package com.test.gse

import android.app.Application
import com.test.gse.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules (AppModule.userModule)
            androidLogger()
            androidContext(this@MainApplication)
        }
    }
}