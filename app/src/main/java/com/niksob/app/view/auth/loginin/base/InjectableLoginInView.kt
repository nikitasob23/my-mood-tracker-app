package com.niksob.app.view.auth.loginin.base

import com.niksob.di.component.view.auth.loginin.DaggerLoginInViewComponent

open class InjectableLoginInView : BaseLoginInView() {

    protected open val injectableComponentBuilder: DaggerLoginInViewComponent.Builder
        get() = DaggerLoginInViewComponent.builder()
}