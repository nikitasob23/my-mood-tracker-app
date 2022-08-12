package com.niksob.di.module.storage

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.db.firebase.provider.FirebaseAuthProvider
import dagger.Module
import dagger.Provides

@Module
class AuthProviderModule {

    @Provides
    fun provideDbProvider(): AuthProvider = FirebaseAuthProvider()
}