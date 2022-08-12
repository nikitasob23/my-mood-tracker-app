package com.niksob.data.provider

import com.google.firebase.database.DatabaseReference

interface DbProvider {

    val dbReference: DatabaseReference
}