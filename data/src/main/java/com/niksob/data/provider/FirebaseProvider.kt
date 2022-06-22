package com.niksob.data.provider

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

private const val DB_REF = "https://mygoodmood-8d862-default-rtdb.europe-west1.firebasedatabase.app/"

class FirebaseProvider(
) : DbProvider {

//    init {
//        FirebaseOfflineWork.turnOn()
//    }

    override fun getAuth() = FirebaseAuth.getInstance()

    override fun getDbReference(): DatabaseReference = Firebase.database(DB_REF).reference
}