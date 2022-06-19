package com.niksob.domain.data.converter

interface MoodEmojiIdConverter {

    fun getEmojiIdByMoodDegree(degree: Int): Int
}
