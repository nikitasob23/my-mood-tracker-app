package com.niksob.data.storage.db.firebase

import com.google.firebase.database.DatabaseReference
import com.niksob.data.storage.db.DbUserStorage
import com.niksob.data.storage.string.StringStorage
import com.niksob.domain.data.dto.db.UserCallbackDto
import com.niksob.domain.data.dto.db.UserResponseDto


private const val SUCCESS_USER_ADDITION = "success_user_addition"
private const val FAILED_USER_ADDITION = "failed_user_addition"

class DbUserFirebase(
    private val usersDbRef: DatabaseReference,
    private val stringStorage: StringStorage,
) : DbUserStorage {
    override fun addUser(userCallback: UserCallbackDto) {
        val uid = userCallback.user.id
        val email = userCallback.user.email
        val callback = userCallback.callback

        usersDbRef.setValue(uid)
            .addOnCompleteListener {
                val response = UserResponseDto(
                    success = true,
                    reason = stringStorage.getString(SUCCESS_USER_ADDITION)
                )
                callback.invoke(response)

            }.addOnCanceledListener {
                val response = UserResponseDto(
                    success = false,
                    reason = stringStorage.getString(FAILED_USER_ADDITION)
                )
                callback.invoke(response)
            }

        usersDbRef.child(uid)
            .setValue(email)
            .addOnCompleteListener {
                val response = UserResponseDto(
                    success = true,
                    reason = stringStorage.getString(SUCCESS_USER_ADDITION)
                )
                callback.invoke(response)

            }.addOnCanceledListener {
                val response = UserResponseDto(
                    success = false,
                    reason = stringStorage.getString(FAILED_USER_ADDITION)
                )
                callback.invoke(response)
            }
    }
}