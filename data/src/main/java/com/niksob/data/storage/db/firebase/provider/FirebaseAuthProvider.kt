package com.niksob.data.storage.db.firebase.provider

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.provider.AuthProvider

class FirebaseAuthProvider : AuthProvider {

    override val auth = FirebaseAuth.getInstance()
}