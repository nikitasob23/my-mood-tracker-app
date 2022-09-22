package com.niksob.app.view.auth.login.base

import com.niksob.di.component.view.auth.login.DaggerLoginViewComponent

open class InjectableBaseLoginView : BaseLoginView() {

    protected open val injectableComponentBuilder: DaggerLoginViewComponent.Builder
        get() = DaggerLoginViewComponent.builder()
}
