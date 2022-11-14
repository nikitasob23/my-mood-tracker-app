package com.niksob.domain.data.dto

import com.niksob.domain.model.Uid

data class MoodEntriesDto(
    val uid: Uid,
    val data: List<MoodEntryDto>,
) {
    val map: Map<String, Any> get() =
        data.map { it.toMap(uid) }
            .map { it as MutableMap }
            .reduce { map1, map2 ->
                map1.putAll(map2)
                map1
            }
}
