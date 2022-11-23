package com.niksob.app.converter

import com.niksob.data.converter.DataConverter
import com.niksob.data.model.UIMoodTag
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.model.mood_tag.MoodTag

class UIMoodTagConverter(
    private val colorIdConverter: MoodColorIdConverter,
) : DataConverter<MoodTag, UIMoodTag> {

    override fun convert(t: MoodTag) =
        UIMoodTag(
            id = t.id,
            entryId = t.entryId,
            name = t.name,
            colorId = colorIdConverter.getColorIdByMoodDegree(t.degree),
        )
}