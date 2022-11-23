package com.niksob.data.converter

import com.niksob.domain.model.ColorId
import com.niksob.domain.data.converter.MoodColorIdConverter
import com.niksob.domain.data.provider.AppColorIdProvider


private const val TERRIBLE_COLOR_KEY = "terrible"
private const val BAD_COLOR_KEY = "bad"
private const val NEUTRAL_COLOR_KEY = "neutral"
private const val GOOD_COLOR_KEY = "good"
private const val EXCELLENT_COLOR_KEY = "excellent"

class MoodColorIdConverterImpl(
    private val appColorProvider: AppColorIdProvider
) : MoodColorIdConverter {

    override fun getColorIdByMoodDegree(degree: Int): Int {

        return when (degree) {
            0 -> appColorProvider.getColorId(TERRIBLE_COLOR_KEY)
            1 -> appColorProvider.getColorId(BAD_COLOR_KEY)
            2 -> appColorProvider.getColorId(NEUTRAL_COLOR_KEY)
            3 -> appColorProvider.getColorId(GOOD_COLOR_KEY)
            4 -> appColorProvider.getColorId(EXCELLENT_COLOR_KEY)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getColorByMoodDegree(degree: Int) =
        ColorId(
            getColorIdByMoodDegree(degree)
        )
}
