package com.niksob.di.component.view.base

import com.niksob.app.view.base.injection.InjectedView
import com.niksob.di.module.logger.AppDebugLoggerModule
import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.di.module.progressbar.AppProgressBarFromContextModule
import com.niksob.di.module.toast.ShortToastMessageModule
import dagger.Component

@Component(
    modules =
    [
        ScreenNavigationModule::class,
        AppProgressBarFromContextModule::class,
        ShortToastMessageModule::class,
        AppDebugLoggerModule::class,
    ]
)
interface BaseViewComponent {
    fun inject(baseView: InjectedView)
}