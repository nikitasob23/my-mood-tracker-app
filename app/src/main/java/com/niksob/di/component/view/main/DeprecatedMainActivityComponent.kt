package com.niksob.di.component.view.main

import com.niksob.di.module.navigation.ScreenNavigationModule
import com.niksob.app.view.main.DeprecatedMainActivity
import com.niksob.di.module.view.main.MainActivityViewModelModule
import dagger.Component

@Component(
    modules = [
        MainActivityViewModelModule::class,
        ScreenNavigationModule::class,
    ]
)
interface DeprecatedMainActivityComponent {

    fun inject(mainActivity: DeprecatedMainActivity)
}