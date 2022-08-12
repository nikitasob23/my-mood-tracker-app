package com.niksob.data.storage.db.firebase.provider

private const val DB_MOOD_ENTRY_REF = "mood_entries"

class MoodEntryFirebaseRefProvider : BaseFirebaseRefProvider() {

    override val dbReference = super.dbReference
        .child(DB_MOOD_ENTRY_REF)
}