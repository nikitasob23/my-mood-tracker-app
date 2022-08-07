package com.niksob.data.storage.db.firebase.saver

import com.google.android.gms.tasks.Task
import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

open class SaveCompletionAction(
    private val reasonProvider: ResponseReasonProvider,
) {
    protected fun onComplete(task: Task<Void>, callback: Callback<Query>) {
        val entryResponse =
            if (task.isSuccessful)
                Query(completed = reasonProvider.successStatus, reason = reasonProvider.successfulReason)
            else
                Query(reason = reasonProvider.failureReason(task.exception?.message))
        callback.call(entryResponse)
    }
}
