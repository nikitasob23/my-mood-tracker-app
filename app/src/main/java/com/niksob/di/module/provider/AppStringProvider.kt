package com.niksob.di.module.provider

import android.content.Context
import com.niksob.data.provider.AppStringProvider
import com.niksob.di.module.app.ContextModule
import com.niksob.utils.AndroidStringProvider
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class AppStringProviderModule {
    @Provides
    fun provideStringProvider(context: Context): AppStringProvider = AndroidStringProvider(context)
}