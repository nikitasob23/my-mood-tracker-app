package com.niksob.di.module.app

import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
class FragmentManagerModule(
    private val manager: FragmentManager
) {
    @Provides
    fun provideFragmentManager() = manager
}