package com.niksob.data.storage.db.firebase.screen.mood.tag

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.db.MoodTagStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.data.storage.db.firebase.saver.FirebaseSaver
import com.niksob.data.storage.db.firebase.screen.mood.tag.loading.LoadableDbMoodTagFirebase
import com.niksob.domain.model.Query

class DbMoodTagFirebase(
    private val moodTagDbProvider: DbFirebaseRefProvider,
    private val saver: FirebaseSaver,
    loader: FirebaseLoader,
) : MoodTagStorage, LoadableDbMoodTagFirebase(moodTagDbProvider, loader) {

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