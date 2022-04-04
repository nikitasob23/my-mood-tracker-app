package com.niksob.di.module.storage

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Named

private const val DB_REF = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"
private const val USERS_DB_REF = "users"

@Module
class FirebaseModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Named("users_db_ref")
    fun provideUserDbReference(@Named("db_ref") dbRef: DatabaseReference) = dbRef.child(USERS_DB_REF)

    @Provides
    @Named("db_ref")
    fun provideDbReference() = Firebase.database(DB_REF).reference
}