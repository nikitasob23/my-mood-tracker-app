package com.niksob.data.storage.firebase.base.provider

private const val DB_USER_REF = "users"

class UserFirebaseRefProvider : BaseFirebaseRefProvider() {

    override val ref = super.ref
        .child(DB_USER_REF)
}