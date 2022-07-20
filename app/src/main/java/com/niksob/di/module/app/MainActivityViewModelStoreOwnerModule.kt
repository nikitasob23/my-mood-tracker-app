package com.niksob.di.module.app

import androidx.lifecycle.ViewModelStoreOwner
import dagger.Module
import dagger.Provides

@Module
class MainActivityViewModelStoreOwnerModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideViewModelStoreOwner() = viewModelStoreOwner
}
