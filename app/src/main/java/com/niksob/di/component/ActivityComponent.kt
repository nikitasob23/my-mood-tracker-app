package com.niksob.di.component

import com.niksob.di.module.ActivityModule
import com.niksob.di.module.AppProgressBarModule
import com.niksob.di.module.HomeScreenModule
import com.niksob.di.module.ScreenNavigationModule
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
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