package com.niksob.di.component

import com.niksob.di.module.activity.ActivityModule
import com.niksob.di.module.activity.AppProgressBarModule
import com.niksob.di.module.activity.HomeScreenModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.presentation.MainActivity
import dagger.Component

@Component(modules = [
    ActivityModule::class,
    HomeScreenModule::class,
    ScreenNavigationModule::class,
    AppProgressBarModule::class,
])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}