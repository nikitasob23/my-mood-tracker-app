package com.niksob.di.module.app

import com.niksob.domain.navigation.NavigationableScreen
import com.niksob.presentation.view.LoginView
import dagger.Module
import dagger.Provides

@Module
class HomeScreenModule {
    @Provides
    fun provideHomeScreen(): NavigationableScreen = LoginView()
}