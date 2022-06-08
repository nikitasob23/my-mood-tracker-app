package com.niksob.data.provider

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

interface DbProvider {
    fun getAuth(): FirebaseAuth

    fun getUserReference(): DatabaseReference
}