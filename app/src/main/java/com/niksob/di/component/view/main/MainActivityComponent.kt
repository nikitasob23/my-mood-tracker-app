package com.niksob.di.component.view.main

import com.niksob.app.view.main.activity.logging.injection.InjectedLoggableAuthLoaderMainActivity
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.view.main.navigation.MainActivityWithNavigationModule
import com.niksob.di.module.viewmodel.main.MainActivityViewModelWithObserverModule
import dagger.Component

@Component(
    modules = [
        MainActivityViewModelWithObserverModule::class,
        MainActivityWithNavigationModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: InjectedLoggableAuthLoaderMainActivity)
}