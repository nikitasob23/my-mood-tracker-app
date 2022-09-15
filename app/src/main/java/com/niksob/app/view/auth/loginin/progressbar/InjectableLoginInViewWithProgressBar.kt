package com.niksob.app.view.auth.loginin.progressbar

open class InjectableLoginInViewWithProgressBar : LoginInViewWithProgressBar() {

    override fun inject() = injectableComponent.inject(this)
}