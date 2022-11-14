package com.niksob.di.module.storage.db.firebase_reference_provider

import com.niksob.data.storage.firebase.base.provider.MoodEntryFirebaseRefProvider
import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import dagger.Module
import dagger.Provides

@Module
class FirebaseRefProviderModule {
    @Provides
    fun provideMoodEntryFirebaseRefProvider() = MoodEntryFirebaseRefProvider()

    @Provides
    fun provideMoodTagFirebaseRefProvider() = MoodTagFirebaseRefProvider()
}