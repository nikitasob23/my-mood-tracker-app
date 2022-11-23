package com.niksob.data.converter.mood_entry

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.data.converter.mood_entry.DbMoodEntryConverter
import com.niksob.domain.data.converter.mood_tag.DbMoodTagConverter
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.dto.MoodEntriesDto
import com.niksob.domain.data.dto.MoodTagsFirebaseDto
import com.niksob.domain.model.mood_entry.MoodEntries
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.mood_entry.MoodEntry
import com.niksob.domain.utils.date.ZonedDateTimeUtil
import com.niksob.domain.utils.date.utcDate

class DbMoodEntryConverterImpl(
    private val moodTagConverter: DbMoodTagConverter,
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

    override fun fromDto(moodEntriesDto: Any, moodTagsDataDto: Any) =
        MoodEntries(
            (moodEntriesDto as MoodEntriesDto).data.map { entryDto ->

                val tagsGroupByEntry = moodTagConverter.fromDto(moodTagsDataDto).data
                    .groupBy({ it.entryId }, { it })

                MoodEntry(
                    id = entryDto.id,
                    dateTime = ZonedDateTimeUtil.fromDateAndTime(entryDto.date, entryDto.time),
                    degree = entryDto.degree,
                    tags = tagsGroupByEntry[entryDto.id]!!,
                )
            }
        )

    override fun fromFirebaseDto(moodEntriesDto: Any, moodTagsDto: Any): MoodEntries {
        moodEntriesDto as MoodEntriesDto
        moodTagsDto as MoodTagsFirebaseDto

        return MoodEntries(
            moodEntriesDto.data.map { entryDto ->

                val tagsGroupByEntry = moodTagConverter.fromFirebaseDto(moodTagsDto, moodEntriesDto).data
                    .groupBy({ it.entryId }, { it })

                MoodEntry(
                    id = entryDto.id,
                    dateTime = ZonedDateTimeUtil.fromDateAndTime(entryDto.date, entryDto.time),
                    degree = entryDto.degree,
                    tags = tagsGroupByEntry[entryDto.id]!!,
                )
            }
        )
    }
}