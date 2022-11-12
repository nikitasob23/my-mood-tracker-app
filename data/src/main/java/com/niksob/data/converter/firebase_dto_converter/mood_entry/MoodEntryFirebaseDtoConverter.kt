package com.niksob.data.converter.firebase_dto_converter.mood_entry

import com.google.firebase.database.DataSnapshot
import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.model.DbFirebaseMoodEntryKey.DEGREE
import com.niksob.data.model.DbFirebaseMoodEntryKey.TIME
import com.niksob.data.model.DbFirebaseMoodEntryKey.TAG_IDS
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodEntryDto
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.MoodTagId
import com.niksob.domain.model.Uid

class MoodEntryFirebaseDtoConverter : FirebaseDtoConverter<MoodEntriesDto> {

    override fun fromFirebaseDto(snapshot: DataSnapshot): MoodEntriesDto {
        val loadedMoodEntries = snapshot.children.flatMap { dateSnapshot ->

            dateSnapshot.children.map { idSnapshot ->

                MoodEntryDto(
                    id = MoodEntryId(idSnapshot.key!!),
                    date = dateSnapshot.key!!,
                    degree = idSnapshot.child(DEGREE.key)
                        .getValue(Int::class.java)!!,

                    time = idSnapshot.child(TIME.key)
                        .getValue(String::class.java)!!,

                    tagIds = idSnapshot.child(TAG_IDS.key).children
                        .map { tagIdSnapshot -> MoodTagId(tagIdSnapshot.key!!) },
                )
            }
        }
        return MoodEntriesDto(
            uid = Uid(snapshot.key!!),
            data = loadedMoodEntries,
        )
    }
}