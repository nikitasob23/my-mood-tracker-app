package com.niksob.data.storage.firebase.mood_tag.loading.database_query

import com.google.firebase.database.Query
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import com.niksob.data.storage.firebase.base.provider.MoodTagFirebaseRefProvider
import com.niksob.domain.data.dto.MoodTagDataDto

class LoadMoodTagsByEntryIdQueryFactory(
    private val tagDbProvider: MoodTagFirebaseRefProvider,
) : FirebaseQueryFactory {

    override fun <T : Any> create(dto: T): Query {
        dto as MoodTagDataDto

        return tagDbProvider.ref
            .child(dto.uid.data)
            .ref
    }
}