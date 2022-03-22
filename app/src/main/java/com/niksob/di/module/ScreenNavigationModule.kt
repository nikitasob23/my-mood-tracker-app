package com.niksob.di.module

import androidx.fragment.app.FragmentManager
import com.niksob.presentation.navigation.FragmentNavigation
import com.niksob.presentation.navigation.FragmentSetter
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.navigation.appprogressbar.AppProgressBar
import com.niksob.domain.usecase.PopBackFragmentUseCase
import com.niksob.domain.usecase.SetFragmentUseCase
import com.niksob.presentation.navigation.appprogressbar.MainProgressBar
import dagger.Module
import dagger.Provides

@Module
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