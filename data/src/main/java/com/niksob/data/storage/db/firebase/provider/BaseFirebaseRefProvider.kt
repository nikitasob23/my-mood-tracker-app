package com.niksob.data.storage.db.firebase.provider

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.niksob.data.provider.DbProvider

private const val DB_REF = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"

abstract class BaseFirebaseRefProvider(
) : DbProvider {

    init {
        FirebaseOfflineWork.turnOn()
    }

    override val dbReference = Firebase.database(DB_REF).reference
}