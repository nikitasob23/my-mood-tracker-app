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
    
    private lateinit var requestDtoData: MoodEntriesDataDto

    private val firebaseQuery
        get() = moodEntryDbProvider.ref
            .child(requestDtoData.uid.data)
            .orderByKey()
            .startAt(requestDtoData.startDate)
            .endAt(requestDtoData.endDate)

    override fun loadByUserIdAndDate(requestDto: Query) {

        requestDtoData = requestDto.data as MoodEntriesDataDto
        loader.load(requestDto, firebaseQuery)
    }
}