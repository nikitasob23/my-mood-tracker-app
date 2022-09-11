package com.niksob.di.component.view

import com.niksob.di.module.navigation.AppScreenNavigationModule
import com.niksob.domain.navigation.ScreenNavigation
import dagger.Component

@Component(modules = [AppScreenNavigationModule::class])
interface NavigationInjectionComponent {
    fun getNavigation(): ScreenNavigation
}