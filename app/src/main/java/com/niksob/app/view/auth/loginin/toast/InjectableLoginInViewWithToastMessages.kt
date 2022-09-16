package com.niksob.app.view.auth.loginin.toast

open class InjectableLoginInViewWithToastMessages : LoginInViewWithToastMessages() {

    override fun inject() = injectableComponent.inject(this)
}