package com.niksob.di.component.view.main

import com.niksob.app.view.main.InjectedMainActivity
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.view.main.MainActivityViewModelWithObserverModule
import dagger.Component

@Component(
    modules = [
        MainActivityViewModelWithObserverModule::class,
        ScreenNavigationModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: InjectedMainActivity)
}