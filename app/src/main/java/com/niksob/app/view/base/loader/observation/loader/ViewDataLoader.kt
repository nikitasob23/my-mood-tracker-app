package com.niksob.app.view.base.loader.observation.loader

import io.reactivex.Single

interface ViewDataLoader<T : Any> {
    fun load(): Single<T>
}