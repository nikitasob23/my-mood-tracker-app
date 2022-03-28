package com.niksob.di.component

import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.di.module.app.AppProgressBarModule
import com.niksob.di.module.app.HomeScreenModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.presentation.MainActivity
import dagger.Component

@Component(modules = [
    FragmentManagerModule::class,
    HomeScreenModule::class,
    ScreenNavigationModule::class,
    AppProgressBarModule::class,
])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}