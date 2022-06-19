package com.niksob.domain.data.converter

interface MoodColorIdConverter {

    fun getColorIdByMoodDegree(degree: Int): Int
}
