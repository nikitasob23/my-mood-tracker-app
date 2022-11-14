package com.niksob.di.module.storage.db.auth.loader

import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.firebase.base.loader.FirebaseAuthorizedUserLoader
import com.niksob.data.storage.firebase.base.loader.FirebaseAuthorizedUserLoaderImpl
import com.niksob.di.module.storage.auth.AuthProviderModule
import dagger.Module
import dagger.Provides

@Module(includes = [AuthProviderModule::class])
class FirebaseAuthorizedUserLoaderModule {
    @Provides
    fun provideFirebaseAuthorizedUserLoader(authProvider: AuthProvider): FirebaseAuthorizedUserLoader =
        FirebaseAuthorizedUserLoaderImpl(authProvider)
}