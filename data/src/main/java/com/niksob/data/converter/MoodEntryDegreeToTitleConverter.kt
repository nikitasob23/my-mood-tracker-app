package com.niksob.data.converter

import com.niksob.data.model.MoodEntryTitle
import com.niksob.data.provider.AppStringProvider
import java.lang.IllegalArgumentException

private const val DEGREE_OUT_OF_RANGE = "Mood entry degree is out of range"

class MoodEntryDegreeToTitleConverter(
    private val stringProvider: AppStringProvider,
) : DataConverter<Int, String> {

    override fun convert(t: Int) =
        when (t) {
            0 -> stringProvider.getString(MoodEntryTitle.TERRIBLE.stringId)
            1 -> stringProvider.getString(MoodEntryTitle.BAD.stringId)
            2 -> stringProvider.getString(MoodEntryTitle.NEUTRAL.stringId)
            3 -> stringProvider.getString(MoodEntryTitle.GOOD.stringId)
            4 -> stringProvider.getString(MoodEntryTitle.EXCELLENT.stringId)
            else -> throw IllegalArgumentException(DEGREE_OUT_OF_RANGE)
        }
}