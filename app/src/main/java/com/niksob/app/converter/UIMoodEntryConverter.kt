package com.niksob.app.converter

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import com.niksob.data.converter.DataConverter
import com.niksob.data.model.*
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.model.MoodEntryId
import com.niksob.domain.model.mood_tag.MoodTag
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.model.mood_entry.MoodEntry

class UIMoodEntryConverter(
    private val context: Context,
    private val moodTagUIConverter: DataConverter<MoodTag, UIMoodTag>,
    private val moodEntryDegreeToTitleConverter: DataConverter<Int, String>,
    private val emojiIdConverter: MoodEmojiIdConverter,
    private val colorIdConverter: MoodColorIdConverter,
    private val clickAction: ClickAction<MoodEntryId>,
) : DataConverter<MoodEntries, UIMoodEntries> {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun convert(t: MoodEntries) = UIMoodEntries(
        t.data.map(this::mappingMoodEntry)
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun mappingMoodEntry(moodEntry: MoodEntry) =
        UIMoodEntry(
            id = moodEntry.id,
            title = moodEntryDegreeToTitleConverter.convert(moodEntry.degree),
            dateTime = moodEntry.dateTime,
            colorId = colorIdConverter.getColorByMoodDegree(moodEntry.degree),
            emoji = getEmojiByDegree(moodEntry.degree),
            tags = UIMoodTags(
                moodEntry.tags.map(moodTagUIConverter::convert)
            ),
        ) { clickAction.onClick(moodEntry.id) }

    private fun getEmojiByDegree(degree: Int) = listOf(degree)
        .map(emojiIdConverter::getEmojiIdByMoodDegree)
        .map { AppCompatResources.getDrawable(context, it) }
        .first()
}