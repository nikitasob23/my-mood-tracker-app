package com.niksob.di.db

import com.niksob.data.provider.DbProvider
import com.niksob.data.provider.FirebaseProvider
import dagger.Module
import dagger.Provides

@Module
class DbProviderModule {
    @Provides
    fun provideDbProvider(): DbProvider = FirebaseProvider()
}