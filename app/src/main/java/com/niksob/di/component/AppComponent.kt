package com.niksob.di.component

import com.niksob.di.module.AppModule
import com.niksob.di.module.ScreenNavigationModule
import com.niksob.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, ScreenNavigationModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}