package com.niksob.data.storage.firebase.base.loader

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.niksob.domain.model.Query

interface OnDataLoadedAction {

    fun onDataLoaded(userIdSnapshot: DataSnapshot, request: Query)

    fun onDataCancelled(error: DatabaseError, request: Query)
}