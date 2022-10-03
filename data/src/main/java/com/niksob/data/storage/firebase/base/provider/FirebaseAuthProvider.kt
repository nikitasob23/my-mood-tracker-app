package com.niksob.data.storage.firebase.base.provider

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.provider.AuthProvider

class FirebaseAuthProvider : AuthProvider {

    override val auth = FirebaseAuth.getInstance()
}