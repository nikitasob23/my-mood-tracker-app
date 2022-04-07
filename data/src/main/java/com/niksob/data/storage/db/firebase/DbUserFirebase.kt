package com.niksob.data.storage.db.firebase

import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.niksob.data.storage.db.DbUserStorage
import com.niksob.data.storage.string.StringStorage
import com.niksob.domain.data.dto.UserDto
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query


const val SUCCESS_USER_ADDITION = "success_user_addition"
const val FAILED_USER_ADDITION = "failed_user_addition"

class DbUserFirebase(
    private val usersDbRef: DatabaseReference,
    private val stringStorage: StringStorage,
) : DbUserStorage, OnCompleteListener<Void>, OnCanceledListener {

    private var callback: Callback<Query>? = null

    override fun addUser(query: Query) {

        val user = query.data as UserDto
        callback = query.callback

        setUserId(user)
        setEmail(user)
    }

    private fun setUserId(user: UserDto) {

        usersDbRef.setValue(user.id)
            .addOnCompleteListener(this)
            .addOnCanceledListener(this)
    }

    private fun setEmail(user: UserDto) {

        usersDbRef.child(user.id)
            .setValue(user.email)
            .addOnCompleteListener(this)
            .addOnCanceledListener(this)
    }

    override fun onComplete(task: Task<Void>) {

        val query = Query(
            completed = true,
            reason = stringStorage.getString(SUCCESS_USER_ADDITION)
        )
        callback?.call?.invoke(query)
    }

    override fun onCanceled() {

        val query = Query(
            reason = stringStorage.getString(FAILED_USER_ADDITION)
        )
        callback?.call?.invoke(query)
    }

}