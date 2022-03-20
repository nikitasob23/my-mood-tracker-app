package com.niksob.di.module

import androidx.fragment.app.FragmentManager
import com.niksob.presentation.navigation.FragmentNavigation
import com.niksob.presentation.navigation.FragmentSetter
import com.niksob.domain.navigation.ScreenNavigation
import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.usecase.PopBackFragmentUseCase
import com.niksob.domain.usecase.SetFragmentUseCase
import dagger.Module
import dagger.Provides

@Module
class ScreenNavigationModule {

    @Provides
    fun provideFragmentNavigation(
        setFragmentUseCase: SetFragmentUseCase,
        popBackFragmentUseCase: PopBackFragmentUseCase,
    ): ScreenNavigation =
        FragmentNavigation(setFragmentUseCase, popBackFragmentUseCase)

    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)

    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) = PopBackFragmentUseCase(screenSetter)

    @Provides
    fun provideFragmentSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)
}