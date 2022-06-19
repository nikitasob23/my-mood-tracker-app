package com.niksob.di.module.provider

import android.content.Context
import com.niksob.di.module.app.ContextModule
import com.niksob.domain.data.provider.AppDrawableIdProvider
import com.niksob.utils.AndroidAppDrawableIdProvider
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class AppDrawableIdProviderModule {
    @Provides
    fun provideAppDrawableIdProvider(context: Context): AppDrawableIdProvider = AndroidAppDrawableIdProvider(context)
}
