package com.niksob.data.storage.firebase.user

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver

interface SavableFirebaseStorage {

    val dbProvider: DbFirebaseRefProvider

    val saver: FirebaseSaver
}