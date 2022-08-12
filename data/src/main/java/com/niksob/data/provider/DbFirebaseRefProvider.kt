package com.niksob.data.provider

import com.google.firebase.database.DatabaseReference

interface DbFirebaseRefProvider {

    val ref: DatabaseReference
}