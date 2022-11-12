package com.niksob.data.storage.firebase.base.loader.database_query_factory

import com.google.firebase.database.Query

interface FirebaseQueryFactory {
    fun <T : Any> create(dto: T): Query
}
