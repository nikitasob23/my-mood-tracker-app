package com.niksob.data.converter

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.DbMoodTagConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.data.dto.*
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.utils.date.ZonedDateTimeUtil
import com.niksob.domain.utils.date.utcDate


class DbMoodEntryConverterImpl(
    private val moodTagConverter: DbMoodTagConverter,
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

    override fun fromDto(moodEntriesDataDto: Any, moodTagsDataDto: Any) =
        MoodEntries(
            (moodEntriesDataDto as MoodEntriesDto).data.map { entryDto ->

                val tagsGroupByEntry = moodTagConverter.fromDto(moodTagsDataDto as MoodTagsDto).data
                    .groupBy({ it.entryId }, { it })

                MoodEntry(
                    id = entryDto.id,
                    dateTime = ZonedDateTimeUtil.fromDateAndTime(entryDto.date, entryDto.time),
                    colorId = moodColorIdConverter.getColorIdByMoodDegree(entryDto.degree),
                    emojiId = moodEmojiIdConverter.getEmojiIdByMoodDegree(entryDto.degree),
                    tags = tagsGroupByEntry[entryDto.id]!!,
                )
            }
        )
}