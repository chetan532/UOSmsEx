package com.cv.uosmsex.di

import com.cv.uosmsex.presentation.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}