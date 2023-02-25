package com.cv.uosmsex

import android.app.Application
import com.cv.uosmsex.di.ApplicationComponent
import com.cv.uosmsex.di.DaggerApplicationComponent

class MainApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}