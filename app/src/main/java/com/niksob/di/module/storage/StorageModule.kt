package com.niksob.di.module.storage

import com.niksob.data.storage.db.firebase.provider.FirebaseOfflineWork
import com.niksob.di.module.storage.db.DbMoodEntryFirebaseModule
import com.niksob.di.module.storage.db.DbMoodTagFirebaseModule
import com.niksob.di.module.storage.db.DbUserFirebaseModule
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