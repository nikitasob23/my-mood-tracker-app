package com.niksob.di.module.storage.db.mood_tag.saver

import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaver
import com.niksob.data.storage.firebase.base.saver.FirebaseStorageSaverImpl
import com.niksob.di.module.storage.db.firebase_reference_provider.FirebaseRefProviderModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [FirebaseRefProviderModule::class])
class MoodTagSaverModule {
    @Provides
    @Named("mood_tag_firebase_storage_saver")
    fun provideMoodTagSaver(refProvider: MoodTagFirebaseRefProvider): FirebaseStorageSaver =
        FirebaseStorageSaverImpl(refProvider)
}