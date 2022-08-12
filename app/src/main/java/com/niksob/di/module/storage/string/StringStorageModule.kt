package com.niksob.di.module.storage.string

import com.niksob.data.provider.AppStringProvider
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.di.module.provider.AppStringProviderModule
import dagger.Module
import dagger.Provides

@Module(includes = [AppStringProviderModule::class])
class StringStorageModule {
    @Provides
    fun provideStringStorage(provider: AppStringProvider) = AppStringStorage(provider)
}