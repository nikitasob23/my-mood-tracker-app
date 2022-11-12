package com.niksob.data.converter.firebase_dto_converter.mood_tag

import com.google.firebase.database.DataSnapshot
import com.niksob.data.converter.firebase_dto_converter.base.FirebaseDtoConverter
import com.niksob.data.model.DbFirebaseMoodTagKey.NAME
import com.niksob.data.model.DbFirebaseMoodTagKey.DEGREE
import com.niksob.domain.data.dto.MoodTagFirebaseDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import com.niksob.domain.model.MoodTagId

class MoodTagFirebaseDtoConverter : FirebaseDtoConverter<MoodTagsFirebaseDto> {

    override fun fromFirebaseDto(snapshot: DataSnapshot): MoodTagsFirebaseDto {
        val moodTagsList = snapshot.children.map { idSnapshot ->
            MoodTagFirebaseDto(
                id = MoodTagId(idSnapshot.key!!),
                degree = idSnapshot.child(DEGREE.key)
                    .getValue(Int::class.java)!!,
                name = idSnapshot.child(NAME.key)
                    .getValue(String::class.java)!!,
            )
        }
        return MoodTagsFirebaseDto(moodTagsList)
    }
}