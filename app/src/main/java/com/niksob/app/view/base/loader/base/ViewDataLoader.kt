package com.niksob.app.view.base.loader.base

import io.reactivex.Single

interface ViewDataLoader<T : Any> {
    fun load(): Single<T>
}