package com.niksob.data.storage.firebase.user

import com.niksob.data.model.user.UserDataKey.EMAIL
import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.base.user.UserStorage
import com.niksob.domain.data.dto.UserDto
import com.niksob.domain.model.Query

class SavableDbUserFirebase(
    override val dbProvider: DbFirebaseRefProvider,
    override val saver: FirebaseSaver,
) : UserStorage, SavableFirebaseStorage {

    protected lateinit var user: UserDto

    protected val firebaseQuery
        get() = dbProvider.ref
            .updateChildren(userIdToEmailMap)

    private val userIdToEmailMap
        get() = mapOf(
            user.id.data to emailMap,
        )

    private val emailMap
        get() = mapOf(
            EMAIL.value to user.email,
        )

    override fun addUser(request: Query) {

        user = request.data as UserDto
        saver.save(task = firebaseQuery, callback = request.callback!!)
    }
}