package com.niksob.di.module.storage.auth

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.firebase.base.provider.FirebaseAuthProvider
import dagger.Module
import dagger.Provides

@Module
class AuthProviderModule {

    @Provides
    fun provideDbProvider(): AuthProvider = FirebaseAuthProvider()
}