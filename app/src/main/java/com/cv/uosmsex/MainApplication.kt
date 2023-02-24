package com.cv.uosmsex

import android.app.Application
import com.cv.uosmsex.di.ApplicationComponent

class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

//        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}