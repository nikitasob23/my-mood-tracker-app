package com.niksob.app.view.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.niksob.app.R
import com.niksob.app.view.main.activity.base.BaseView
import com.niksob.di.component.view.auth.login.DaggerLoginViewComponent
import com.niksob.domain.navigation.NavigationableScreen
import javax.inject.Inject
import javax.inject.Named

open class DeprecatedLoginView : BaseView() {

    override val layout = R.layout.login_view

    @Inject
    @Named("provide_login_in_view_class")
    lateinit var loginInViewClass: Class<out NavigationableScreen>

    @Inject
    @Named("provide_sign_up_view_class")
    lateinit var signUpViewClass: Class<out NavigationableScreen>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()

        initComponents()

        return rootView
    }

    private fun inject() {
        DaggerLoginViewComponent.create()
            .inject(this)
    }

    private fun initComponents() {
        rootView.findViewById<AppCompatButton>(R.id.login_view__login_in_button).setOnClickListener {
            navigation?.goToNextView(loginInViewClass)
        }
        rootView.findViewById<AppCompatButton>(R.id.login_view__sign_up_button).setOnClickListener {
            navigation?.goToNextView(signUpViewClass)
        }
    }
}