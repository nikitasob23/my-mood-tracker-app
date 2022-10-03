package com.niksob.di.module.storage

import com.niksob.data.storage.firebase.base.provider.FirebaseOfflineWork
import com.niksob.di.module.storage.db.moodentry.DbMoodEntryFirebaseModule
import com.niksob.di.module.storage.db.moodtag.DbMoodTagFirebaseModule
import com.niksob.di.module.storage.db.user.DbUserFirebaseModule
import dagger.Module

@Module(
    includes = [
        DbUserFirebaseModule::class,
        DbMoodEntryFirebaseModule::class,
        DbMoodTagFirebaseModule::class,
    ]
)
class StorageModule {

    init {
        FirebaseOfflineWork.turnOn()
    }
}