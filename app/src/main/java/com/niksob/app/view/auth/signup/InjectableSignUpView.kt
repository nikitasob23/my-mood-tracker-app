package com.niksob.app.view.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niksob.di.component.view.auth.signup.DaggerAppSignUpViewComponent
import com.niksob.app.view.Injectable

open class InjectableSignUpView : Injectable, BaseSignUpView() {

    protected open val injectableComponentBuilder: DaggerAppSignUpViewComponent.Builder
        get() = DaggerAppSignUpViewComponent.builder()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = super.onCreateView(inflater, container, savedInstanceState)
        inject()
        return rootView
    }

    override fun inject() = Unit
}