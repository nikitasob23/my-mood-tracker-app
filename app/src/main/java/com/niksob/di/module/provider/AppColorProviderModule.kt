package com.niksob.di.module.provider

import android.content.Context
import com.niksob.di.module.app.ContextModule
import com.niksob.domain.data.provider.AppColorIdProvider
import com.niksob.utils.AndroidAppColorIdProvider
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class AppColorProviderModule {
    @Provides
    fun provideAppColorProvider(context: Context): AppColorIdProvider = AndroidAppColorIdProvider(context)
}