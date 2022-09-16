package com.niksob.app.view.auth.loginin.progressbar

open class InjectableLoggableLoginInView : LoggableLoginInView() {

    override fun inject() = injectableComponent.inject(this)
}