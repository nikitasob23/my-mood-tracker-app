package com.niksob.data.provider

import com.google.firebase.auth.FirebaseAuth

interface AuthProvider {

    val auth: FirebaseAuth
}