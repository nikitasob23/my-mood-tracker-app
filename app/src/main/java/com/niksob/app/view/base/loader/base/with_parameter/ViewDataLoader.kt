package com.niksob.app.view.base.loader.base.with_parameter

import io.reactivex.Single

interface ViewDataLoader<T : Any, U : Any> {
    fun load(data: T? = null): Single<U>
}