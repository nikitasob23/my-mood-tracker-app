package com.niksob.data.storage.firebase.mood.entry.loading

import com.niksob.data.provider.DbFirebaseRefProvider
import com.niksob.data.storage.firebase.base.loader.FirebaseLoader
import com.niksob.data.storage.base.mood.entry.loading.LoadableMoodEntryStorage
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