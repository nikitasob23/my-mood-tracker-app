package com.niksob.data.storage.db.firebase.screen.mood.entry.loading

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.db.LoadableMoodEntryStorage
import com.niksob.data.storage.db.firebase.loader.FirebaseLoader
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.model.Query

open class LoadableDbMoodEntryFirebase(
    private val moodEntryDbProvider: DbFirebaseRefProvider,
    private val loader: FirebaseLoader,
) : LoadableMoodEntryStorage {
    
    override fun loadByUserIdAndDate(requestDto: Query) =
        loader.load(
            requestDto,
            firebaseQuery(requestDto.data as MoodEntriesDataDto)
        )

    private fun firebaseQuery(requestDtoData: MoodEntriesDataDto) =
        moodEntryDbProvider.ref
            .child(requestDtoData.uid.data)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .endAt(requestDtoData.endDate)
}