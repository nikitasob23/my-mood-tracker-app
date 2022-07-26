package com.niksob.data.storage.db.firebase.auth

import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.niksob.data.provider.DbProvider
import com.niksob.data.storage.db.UserStorage
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.domain.data.dto.UserDto
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query


const val USERS_DB_REF_NAME = "users"
const val SUCCESS_USER_ADDITION = "success_user_addition"
const val FAILED_USER_ADDITION = "failed_user_addition"

const val EMAIL_KEY = "email"

class DbUserFirebase(
    dbProvider: DbProvider,
    private val stringStorage: AppStringStorage,
) : UserStorage {

    private val usersDbRef: DatabaseReference = dbProvider.getDbReference()
        .child(USERS_DB_REF_NAME)

    private var callback: Callback<Query>? = null

    private val onSuccessListener = OnSuccessListener<Void> {
        val query = Query(
            completed = true,
            reason = stringStorage.getString(SUCCESS_USER_ADDITION)
        )
        callback?.call?.invoke(query)
    }

    private val onCanceledListener = OnCanceledListener {
        val query = Query(
            reason = stringStorage.getString(FAILED_USER_ADDITION)
        )
        callback?.call?.invoke(query)
    }

    override fun addUser(query: Query) {

        val user = query.data as UserDto
        callback = query.callback

        setUserId(user)
        setEmailKey(user)
        setEmailValue(user)
    }

    private fun setUserId(user: UserDto) {

        usersDbRef.setValue(user.id)
    }

    private fun setEmailKey(user: UserDto) {

        usersDbRef.child(user.id)
            .setValue(EMAIL_KEY)
    }

    private fun setEmailValue(user: UserDto) {

        usersDbRef.child(user.id)
            .child(EMAIL_KEY)
            .setValue(user.email)
            .addOnSuccessListener(onSuccessListener)
            .addOnCanceledListener(onCanceledListener)
    }
}