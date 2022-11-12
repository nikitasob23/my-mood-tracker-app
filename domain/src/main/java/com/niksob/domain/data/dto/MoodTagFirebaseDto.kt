package com.niksob.domain.data.dto

import com.niksob.domain.model.MoodTagId

data class MoodTagFirebaseDto(
    val id: MoodTagId,
    val degree: Int,
    val name: String,
)