package com.niksob.app.view.auth.login.uicomponent

import androidx.appcompat.widget.AppCompatButton
import com.niksob.app.R
import com.niksob.app.view.auth.login.navigation.NavigatableLoginView

open class LoginViewWithNavigatableBtns : NavigatableLoginView() {

    protected lateinit var loginInBtn: AppCompatButton

    protected lateinit var signUpBtn: AppCompatButton

    override fun initComponents() {
        super.initComponents()

        loginInBtn = rootView.findViewById(R.id.login_view__login_in_button)
        loginInBtn.setOnClickListener { goToLoginView() }

        signUpBtn = rootView.findViewById(R.id.login_view__sign_up_button)
        signUpBtn.setOnClickListener { goToSignUpView() }
    }
}