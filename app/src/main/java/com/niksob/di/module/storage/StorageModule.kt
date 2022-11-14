package com.niksob.di.module.storage

import com.niksob.data.storage.firebase.base.provider.FirebaseOfflineWork
import com.niksob.di.module.storage.db.mood_entry.DbMoodEntryFirebaseModule
import com.niksob.di.module.storage.db.mood_tag.DbMoodTagFirebaseModule
import com.niksob.di.module.storage.db.user.DbUserFirebaseModule
import com.niksob.di.module.storage.db.mood_entry.observation.ObservableDbMoodEntryFirebaseModule
import com.niksob.di.module.storage.db.mood_tag.observation.ObservableDbMoodTagFirebaseModule
import dagger.Module

@Module(
    includes = [
        DbUserFirebaseModule::class,
        DbMoodEntryFirebaseModule::class,
        ObservableDbMoodEntryFirebaseModule::class,
        DbMoodTagFirebaseModule::class,
        ObservableDbMoodTagFirebaseModule::class,
    ]
)
class StorageModule {

    init {
        FirebaseOfflineWork.turnOn()
    }
}