package com.niksob.app.view.base.ui_components

interface ViewComponent<T> {
    fun bind(data: T)
}