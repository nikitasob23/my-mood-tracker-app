package com.niksob.app.view.auth.loginin

import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.niksob.app.R
import com.niksob.app.view.auth.loginin.navigation.InjectableNavigatableLoginInView

abstract class LoginInViewWithLoginComponent : InjectableNavigatableLoginInView() {

    protected lateinit var emailEditText: EditText
    protected lateinit var passwordEditText: EditText

    protected lateinit var loginInBtn: AppCompatButton

    override fun initComponents() {
        super.initComponents()

        emailEditText = rootView.findViewById(R.id.login_in_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_in_view__password_et)

        loginInBtn = rootView.findViewById(R.id.login_in_view___login_in_button)
        loginInBtn.setOnClickListener { onClickLoginInBtn() }
    }

    abstract fun onClickLoginInBtn()
}