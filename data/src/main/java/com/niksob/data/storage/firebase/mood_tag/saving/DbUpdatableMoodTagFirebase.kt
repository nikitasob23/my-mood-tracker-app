package com.niksob.data.storage.firebase.mood_tag.saving

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.firebase.base.loader.FirebaseLoader
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.firebase.mood_tag.loading.LoadableDbMoodTagFirebase
import com.niksob.data.storage.base.mood.tag.saving.UpdatableMoodTagStorage
import com.niksob.domain.model.Query

class DbUpdatableMoodTagFirebase(
    private val moodTagDbProvider: DbFirebaseRefProvider,
    private val saver: FirebaseSaver,
    loader: FirebaseLoader,
) : UpdatableMoodTagStorage, LoadableDbMoodTagFirebase(moodTagDbProvider, loader) {

    private lateinit var tagsDto: Map<String, Any>

    private val firebaseTask
        get() = moodTagDbProvider.ref
            .updateChildren(tagsDto)

    override fun save(request: Query) {

        @Suppress("UNCHECKED_CAST")
        tagsDto = request.data as Map<String, Any>
        saver.save(firebaseTask, request.callback!!)
    }
}