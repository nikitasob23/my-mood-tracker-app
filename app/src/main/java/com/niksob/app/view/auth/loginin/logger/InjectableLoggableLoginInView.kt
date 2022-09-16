package com.niksob.app.view.auth.loginin.logger

open class InjectableLoggableLoginInView : LoggableLoginInView() {

    override fun inject() = injectableComponent.inject(this)
}