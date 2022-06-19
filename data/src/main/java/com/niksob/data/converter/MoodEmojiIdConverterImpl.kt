package com.niksob.data.converter

import com.niksob.domain.data.converter.MoodEmojiIdConverter
import com.niksob.domain.data.provider.AppDrawableIdProvider


const val TERRIBLE_EMOJI_KEY = "ic_terrible_emoji"
const val BAD_EMOJI_KEY = "ic_bad_emoji"
const val NEUTRAL_EMOJI_KEY = "ic_neutral_emoji"
const val GOOD_EMOJI_KEY = "ic_good_emoji"
const val EXCELLENT_EMOJI_KEY = "ic_excellent_emoji"

class MoodEmojiIdConverterImpl(
    private val appResourceProvider: AppDrawableIdProvider
) : MoodEmojiIdConverter {
    override fun getEmojiIdByMoodDegree(degree: Int): Int {

        return when (degree) {
            0 -> appResourceProvider.getDrawableId(TERRIBLE_EMOJI_KEY)
            1 -> appResourceProvider.getDrawableId(BAD_EMOJI_KEY)
            2 -> appResourceProvider.getDrawableId(NEUTRAL_EMOJI_KEY)
            3 -> appResourceProvider.getDrawableId(GOOD_EMOJI_KEY)
            4 -> appResourceProvider.getDrawableId(EXCELLENT_EMOJI_KEY)
            else -> throw IllegalArgumentException()
        }
    }
}