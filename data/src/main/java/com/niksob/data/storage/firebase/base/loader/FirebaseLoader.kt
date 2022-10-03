package com.niksob.data.storage.firebase.base.loader

interface FirebaseLoader {

    fun load(
        request: com.niksob.domain.model.Query,
        firebaseQuery: com.google.firebase.database.Query,
    )
}
