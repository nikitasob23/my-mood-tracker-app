package com.niksob.data.storage.db.firebase.loader

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class FirebaseLoaderImpl(
    private val action: OnDataLoadedAction,
) : FirebaseLoader {

    private fun getValueEventListener(request: com.niksob.domain.model.Query) =
        object : ValueEventListener {
            override fun onDataChange(userIdSnapshot: DataSnapshot) = action.onDataLoaded(userIdSnapshot, request)

            override fun onCancelled(error: DatabaseError) = action.onDataCancelled(error, request)
        }

    override fun load(
        request: com.niksob.domain.model.Query,
        firebaseQuery: com.google.firebase.database.Query,
    ) {
        val listener = getValueEventListener(request)
        firebaseQuery.addListenerForSingleValueEvent(listener)
    }
}
