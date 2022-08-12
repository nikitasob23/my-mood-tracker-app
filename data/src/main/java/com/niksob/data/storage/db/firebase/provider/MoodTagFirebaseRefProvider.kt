package com.niksob.data.storage.db.firebase.provider

private const val DB_MOOD_TAG_REF = "mood_tags"

class MoodTagFirebaseRefProvider : BaseFirebaseRefProvider() {

    override val ref = super.ref
        .child(DB_MOOD_TAG_REF)
}