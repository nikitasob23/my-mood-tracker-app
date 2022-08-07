package com.niksob.data.storage.db.firebase.saver

import com.google.android.gms.tasks.Task
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface OnDataSavedAction {

    fun onDataLoaded(callback: Callback<Query>)

    fun onDataCancelled(task: Task<Void>, callback: Callback<Query>)
}