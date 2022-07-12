package com.niksob.data.converter

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.MoodEntryDto
import com.niksob.domain.utils.date.ZonedDateTimeUtil
import com.niksob.domain.utils.date.utcDate


class DbMoodEntryConverterImpl(
    private val moodColorIdConverter: MoodColorIdConverter,
    private val moodEmojiIdConverter: MoodEmojiIdConverter,
) : DbMoodEntryConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto {

        val loadedDaysInterval = moodEntriesData.loadedDaysInterval.toLong()
        val dateTimeMinusInterval = moodEntriesData.dateTime.minusDays(loadedDaysInterval)
        val startDate = dateTimeMinusInterval.utcDate

        val dateTimePlusInterval = moodEntriesData.dateTime.plusDays(loadedDaysInterval)
        val endDate = dateTimePlusInterval.utcDate

        return MoodEntriesDataDto(
            uid = moodEntriesData.uid,
            startDate = startDate,
            endDate = endDate,
        )
    }

    @Suppress("UNCHECKED_CAST", "NewApi")
    override fun fromDto(moodEntriesDto: List<MoodEntryDto>) =
        moodEntriesDto.map { entryDto ->

            val dateTime = ZonedDateTimeUtil.fromDateAndTime(entryDto.date, entryDto.time)

            MoodEntry(
                id = entryDto.id,
                dateTime = dateTime,
                colorId = moodColorIdConverter.getColorIdByMoodDegree(entryDto.degree),
                emojiId = moodEmojiIdConverter.getEmojiIdByMoodDegree(entryDto.degree),
            )
        }
}