package com.niksob.data.storage.db.firebase.provider

private const val DB_MOOD_ENTRY_REF = "mood_entries"

class MoodEntryFirebaseRefProvider : BaseFirebaseRefProvider() {

    override val ref = super.ref
        .child(DB_MOOD_ENTRY_REF)
}