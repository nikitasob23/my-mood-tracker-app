package com.niksob.data.storage.firebase.mood_entry.loading.database_query

import com.google.firebase.database.Query
import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.firebase.base.loader.database_query_factory.FirebaseQueryFactory
import com.niksob.domain.data.dto.MoodEntriesDataDto

class LoadMoodEntriesByDateIntervalQueryFactory(
    private val entryDbProvider: DbFirebaseRefProvider,
) : FirebaseQueryFactory {

    override fun <T : Any> create(dto: T): Query {
        dto as MoodEntriesDataDto

        return entryDbProvider.ref
            .child(dto.uid.data)
            .orderByKey()
            .startAt(dto.startDate)
            .endAt(dto.endDate)
    }
}