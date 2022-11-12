package com.niksob.data.storage.firebase.base.loader

import com.google.firebase.database.Query
import com.niksob.data.model.OnDataLoadedAction
import com.niksob.data.model.Request

interface FirebaseStorageLoader<T : Any> {

    fun load(request: Request<Query, OnDataLoadedAction<T>>)
}