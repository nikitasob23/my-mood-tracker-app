package com.niksob.di.module.usecase.navigation

import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.usecase.navigation.SetFragmentUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [ScreenSetterModule::class])
class SetFragmentUseCaseModule {
    @Provides
    fun provideSetFragmentUseCase(screenSetter: ScreenSetter) = SetFragmentUseCase(screenSetter)
}