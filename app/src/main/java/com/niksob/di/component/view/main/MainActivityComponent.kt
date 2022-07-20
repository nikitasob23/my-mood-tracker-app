package com.niksob.di.component.view.main

import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.AppProgressBarModule
import com.niksob.di.module.view.main.MainActivityViewModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.app.view.main.MainActivity
import dagger.Component

@Component(
    modules = [
        MainActivityViewModule::class,
        FragmentManagerModule::class,
        ScreenNavigationModule::class,
        AppProgressBarModule::class,
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}