package com.niksob.domain.data.converter

import com.niksob.domain.model.ColorId

interface MoodColorIdConverter {

    fun getColorIdByMoodDegree(degree: Int): Int

    fun getColorByMoodDegree(degree: Int): ColorId
}
