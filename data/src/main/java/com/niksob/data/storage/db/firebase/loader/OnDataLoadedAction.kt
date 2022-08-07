package com.niksob.data.storage.db.firebase.loader

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.niksob.domain.model.Query

interface OnDataLoadedAction {

    fun onDataLoaded(snapshot: DataSnapshot, request: Query)

    fun onDataCancelled(error: DatabaseError, request: Query)
}