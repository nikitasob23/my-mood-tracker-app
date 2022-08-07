package com.niksob.data.storage.db.firebase.screen.mood.tag.saving

import com.google.android.gms.tasks.Task
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.db.firebase.saver.OnDataSavedAction
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

class MoodTagOnDataSavedAction(
    private val reasonProvider: ResponseReasonProvider,
) : OnDataSavedAction {

    override fun onDataLoaded(callback: Callback<Query>) {
        val response = Query(completed = reasonProvider.successStatus, reason = reasonProvider.successfulReason)
        callback.call(response)
    }

    override fun onDataCancelled(task: Task<Void>, callback: Callback<Query>) {
        val response = Query(reason = reasonProvider.failureReason(task.exception?.message))
        callback.call(response)
    }
}