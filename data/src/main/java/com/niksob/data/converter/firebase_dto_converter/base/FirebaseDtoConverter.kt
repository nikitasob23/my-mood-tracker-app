package com.niksob.data.converter.firebase_dto_converter.base

import com.google.firebase.database.DataSnapshot

interface FirebaseDtoConverter<T> {
    fun fromFirebaseDto(snapshot: DataSnapshot): T
}