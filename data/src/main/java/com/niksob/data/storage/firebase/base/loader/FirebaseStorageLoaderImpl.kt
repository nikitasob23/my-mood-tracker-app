package com.niksob.data.storage.firebase.base.loader

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.model.OnDataLoadedAction
import com.niksob.data.model.Request

class FirebaseStorageLoaderImpl<T : Any>(
    private val firebaseDtoConverter: FirebaseDtoConverter<T>,
) : FirebaseStorageLoader<T> {

    private fun valueEventListener(callback: OnDataLoadedAction<T>) =
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = firebaseDtoConverter.fromFirebaseDto(snapshot)
                callback.onDataLoaded(data)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onDataCancelled(error.toException())
            }
        }

    override fun load(request: Request<Query, OnDataLoadedAction<T>>) {
        val (data, _, callback) = request

        val listener = valueEventListener(callback)
        data.addListenerForSingleValueEvent(listener)
    }
}