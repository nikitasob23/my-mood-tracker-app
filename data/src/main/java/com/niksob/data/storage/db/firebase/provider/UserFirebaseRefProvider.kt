package com.niksob.data.storage.db.firebase.provider

private const val DB_USER_REF = "users"

class UserFirebaseRefProvider : BaseFirebaseRefProvider() {

    override val dbReference = super.dbReference
        .child(DB_USER_REF)
}