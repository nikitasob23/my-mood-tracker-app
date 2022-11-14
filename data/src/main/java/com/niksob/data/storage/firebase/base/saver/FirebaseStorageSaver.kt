package com.niksob.data.storage.firebase.base.saver

import com.niksob.data.model.OnDataCompletedAction
import com.niksob.data.model.Request

interface FirebaseStorageSaver {
    fun <T : Any> save(request: Request<T, OnDataCompletedAction>)
}