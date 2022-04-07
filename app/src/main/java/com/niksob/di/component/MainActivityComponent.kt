package com.niksob.di.component

import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.AppProgressBarModule
import com.niksob.di.module.app.MainActivityViewModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.presentation.MainActivity
import dagger.Component

@Component(modules = [
    MainActivityViewModule::class,
    FragmentManagerModule::class,
    ScreenNavigationModule::class,
    AppProgressBarModule::class,
])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}