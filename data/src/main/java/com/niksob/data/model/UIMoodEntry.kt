package com.niksob.data.model

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.niksob.domain.model.ColorId
import com.niksob.domain.model.MoodEntryId
import java.time.ZonedDateTime

@RequiresApi(Build.VERSION_CODES.O)
data class UIMoodEntry(
    val id: MoodEntryId,
    val title: String = "",
    val dateTime: ZonedDateTime = ZonedDateTime.now(),
    val colorId: ColorId? = null,
    val emoji: Drawable? = null,
    val tags: UIMoodTags = UIMoodTags(),
    val onClick: (() -> Unit)? = null,
)