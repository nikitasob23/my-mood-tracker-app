package com.niksob.app.view.auth.loginin.base

import com.niksob.di.component.view.auth.loginin.DaggerAppLoginInViewComponent

open class InjectableLoginInView : BaseLoginInView() {

    protected open val injectableComponentBuilder: DaggerAppLoginInViewComponent.Builder
        get() = DaggerAppLoginInViewComponent.builder()
}