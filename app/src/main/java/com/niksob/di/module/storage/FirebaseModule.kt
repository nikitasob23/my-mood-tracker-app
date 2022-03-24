package com.niksob.di.module.storage

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides

@Module
class FirebaseModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}