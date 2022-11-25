package com.niksob.di.module.usecase.navigation

import com.niksob.domain.navigation.ScreenSetter
import com.niksob.domain.usecase.navigation.PopBackFragmentUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [ScreenSetterModule::class])
class PopBackFragmentUseCaseModule {
    @Provides
    fun providePopBackFragmentUseCase(screenSetter: ScreenSetter) =
        PopBackFragmentUseCase(screenSetter)
}