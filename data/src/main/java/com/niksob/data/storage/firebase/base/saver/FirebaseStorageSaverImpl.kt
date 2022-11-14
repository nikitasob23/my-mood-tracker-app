package com.niksob.data.storage.firebase.base.saver

import com.google.android.gms.tasks.Task
import com.niksob.data.model.OnDataCompletedAction
import com.niksob.data.model.Request
import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.domain.data.dto.MoodEntriesDto

class FirebaseStorageSaverImpl(
    private val moodEntryDbProvider: DbFirebaseRefProvider,
) : FirebaseStorageSaver {

    private fun onComplete(task: Task<Void>, callback: OnDataCompletedAction) =
        if (task.isSuccessful)
            callback.onDataCompleted()
        else
            callback.onDataCancelled(task.exception!!)


    override fun <T : Any> save(request: Request<T, OnDataCompletedAction>) {
        val (dto, _, callback) = request
        dto as MoodEntriesDto

        moodEntryDbProvider.ref
            .updateChildren(dto.map)
            .addOnCompleteListener { task -> onComplete(task, callback) }
    }
}