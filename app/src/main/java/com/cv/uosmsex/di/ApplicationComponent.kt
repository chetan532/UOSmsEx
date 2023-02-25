package com.cv.uosmsex.di

import android.content.Context
import com.cv.uosmsex.presentation.compose.ComposeActivity
import com.cv.uosmsex.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun injectCompose(composeActivity: ComposeActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}