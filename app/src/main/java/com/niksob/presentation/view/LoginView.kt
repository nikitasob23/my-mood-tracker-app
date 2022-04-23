package com.niksob.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.niksob.di.component.DaggerLoginViewComponent
import com.niksob.presentation.R
import javax.inject.Inject

class LoginView : BaseView() {

    override val layout = R.layout.login_view

    @Inject
    lateinit var loginInViewClass: Class<LoginInView>

    @Inject
    lateinit var signUpViewClass: Class<SignUpView>

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