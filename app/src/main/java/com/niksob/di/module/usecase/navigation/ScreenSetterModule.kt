package com.niksob.di.module.usecase.navigation

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.niksob.app.application.App
import com.niksob.app.navigation.fragmentsetter.FragmentSetter
import com.niksob.di.module.app.ContextModule
import com.niksob.domain.navigation.ScreenSetter
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class ScreenSetterModule {
    @Provides
    fun provideScreenSetter(manager: FragmentManager): ScreenSetter = FragmentSetter(manager)

    @Provides
    fun provideFragmentManager(context: Context) = (context as App).fragmentManager
}