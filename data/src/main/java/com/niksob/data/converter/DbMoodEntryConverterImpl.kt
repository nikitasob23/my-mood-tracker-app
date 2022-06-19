package com.niksob.data.converter

import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.data.dto.MoodEntriesDataDto
import com.niksob.domain.data.converter.DbMoodEntryConverter
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.model.MoodEntriesData
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.utils.date.ZonedDateTimeUtil
import com.niksob.domain.utils.date.utcDate


const val DEGREE_KEY = "degree"
const val TIME_KEY = "time"
const val INCREASE_BY_TWO_COEF = 2

class DbMoodEntryConverterImpl(
    private val moodColorIdConverter: MoodColorIdConverter,
    private val moodEmojiIdConverter: MoodEmojiIdConverter,
) : DbMoodEntryConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toDto(moodEntriesData: MoodEntriesData): MoodEntriesDataDto {

        val dateTimeMinusEdge = moodEntriesData.dateTime.minusDays(moodEntriesData.dayEdge.toLong())
        val startDate = dateTimeMinusEdge.utcDate
        val dayLimit = moodEntriesData.dayEdge * INCREASE_BY_TWO_COEF

        return MoodEntriesDataDto(
            uid = moodEntriesData.uid,
            startDate = startDate,
            dayLimit = dayLimit,
        )
    }

    @Suppress("UNCHECKED_CAST", "NewApi")
    override fun fromDto(moodEntryDto: Map<String, Any>, uid: String): List<MoodEntry> {
        val moodEntries = ArrayList<MoodEntry>()
        moodEntryDto.forEach { (date, idMap) ->

            (idMap as Map<String, Any>).forEach { (id, map) ->

                val castMap = map as Map<String, Any>
                val degree = (castMap[DEGREE_KEY] as Long).toInt()
                val time = castMap[TIME_KEY] as String

                val moodEntry = MoodEntry(
                    id = id,
                    uid = uid,
                    dateTime = ZonedDateTimeUtil.fromDateAndTime(date, time),
                    emojiId = moodEmojiIdConverter.getEmojiIdByMoodDegree(degree),
                    colorId = moodColorIdConverter.getColorIdByMoodDegree(degree),
                )
                moodEntries.add(moodEntry)
            }
        }
        return moodEntries
    }
}