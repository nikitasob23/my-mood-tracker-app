package com.niksob.data.provider

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.niksob.data.storage.db.firebase.FirebaseOfflineWork

private const val DB_REF = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"
private const val USERS_KEY = "users"

class FirebaseProvider(
) : DbProvider {

    init {
        FirebaseOfflineWork.turnOn()
    }

    private val dbReference: DatabaseReference = Firebase.database(DB_REF).reference

    override fun getAuth() = FirebaseAuth.getInstance()

    override fun getUserReference() = dbReference.child(USERS_KEY)
}