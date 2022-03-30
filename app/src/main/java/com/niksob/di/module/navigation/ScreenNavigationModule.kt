package com.niksob.di.module.navigation

import androidx.fragment.app.FragmentManager
import com.niksob.di.module.app.AppProgressBarModule
import com.niksob.di.module.app.FragmentManagerModule
import com.niksob.presentation.navigation.FragmentNavigation
import com.niksob.presentation.navigation.FragmentSetter
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [FragmentManagerModule::class, AppProgressBarModule::class])
class ScreenNavigationModule {

    @Provides
    fun provideFragmentNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
        appProgressBar: AppProgressBar
    ): ScreenNavigation =
        FragmentNavigation(setFragmentUseCase, popBackFragmentUseCase, appProgressBar)

    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)

    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) = PopBackFragmentUseCase(screenSetter)

    @Provides
    fun provideFragmentSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)
}