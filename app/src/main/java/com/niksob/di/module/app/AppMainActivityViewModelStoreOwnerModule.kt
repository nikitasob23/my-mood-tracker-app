package com.niksob.di.module.app

import android.content.Context
import com.niksob.app.application.App
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class AppMainActivityViewModelStoreOwnerModule {
    @Provides
    fun provideMainActivityViewModelStoreOwner(context: Context) = (context as App).mainViewModelStoreOwner
}