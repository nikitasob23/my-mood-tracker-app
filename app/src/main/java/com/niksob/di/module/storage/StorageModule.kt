package com.niksob.di.module.storage

import com.niksob.data.storage.db.MoodEntryStorage
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.UserStorage
import com.niksob.data.storage.db.firebase.screen.auth.DbUserFirebase
import com.niksob.data.storage.db.firebase.screen.mood.entry.DbMoodEntryFirebase
import com.niksob.data.storage.db.firebase.screen.mood.tag.DbMoodTagFirebase
import com.niksob.di.module.storage.db.DbMoodEntryFirebaseModule
import com.niksob.di.module.storage.db.DbMoodTagFirebaseModule
import com.niksob.di.module.storage.db.DbUserFirebaseModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        DbUserFirebaseModule::class,
        DbMoodEntryFirebaseModule::class,
        DbMoodTagFirebaseModule::class,
    ]
)
class StorageModule {

//    init {
//        FirebaseOfflineWork.turnOn()
//    }

    @Provides
    fun provideUserStorage(dbUserFirebase: DbUserFirebase): UserStorage = dbUserFirebase

    @Provides
    fun provideMoodEntryStorage(dbMoodEntryFirebase: DbMoodEntryFirebase): MoodEntryStorage = dbMoodEntryFirebase

    @Provides
    fun provideMoodTagStorage(dbMoodTagFirebase: DbMoodTagFirebase): MoodTagStorage = dbMoodTagFirebase
}