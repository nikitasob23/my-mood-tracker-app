package com.niksob.di.component.view.main

import com.niksob.app.view.main.activity.InjectedMainActivity
import com.niksob.di.module.app.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.navigation.AppScreenNavigationModule
import com.niksob.di.module.view.main.AppMainActivityViewModelWithObserverModule
import dagger.Component

@Component(
    modules = [
        AppMainActivityViewModelWithObserverModule::class,
        AppScreenNavigationModule::class,
        AppProgressBarFromContextModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: InjectedMainActivity)
}