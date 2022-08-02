package com.niksob.di.module.storage

import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.firebase.provider.FirebaseProvider
import dagger.Module
import dagger.Provides

@Module
class DbProviderModule {
    @Provides
    fun provideDbProvider(): DbProvider = FirebaseProvider()
}