package com.niksob.di.module.storage

import android.content.Context
import com.niksob.data.storage.string.AppStringProvider
import com.niksob.data.storage.string.AppStringStorage
import com.niksob.di.module.app.ContextModule
import com.niksob.utils.appstring.AndroidStringProvider
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class StringStorageModule {
    @Provides
    fun provideStringStorage(provider: AppStringProvider) = AppStringStorage(provider)

    @Provides
    fun provideStringProvider(context: Context): AppStringProvider = AndroidStringProvider(context)
}