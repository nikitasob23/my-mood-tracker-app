package com.niksob.di.module.storage

import android.content.Context
import com.niksob.data.StringProvider
import com.niksob.data.storage.string.StringStorage
import com.niksob.di.module.app.ContextModule
import com.niksob.utils.AndroidStringProvider
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class StringStorageModule {
    @Provides
    fun provideStringStorage(provider: StringProvider) = StringStorage(provider)

    @Provides
    fun provideStringProvider(context: Context): StringProvider = AndroidStringProvider(context)
}