package com.niksob.app.view.auth.loginin.base

import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.niksob.app.R
import com.niksob.app.view.auth.loginin.mvvm.InjectableMVVMLoginInView
import com.niksob.app.view.auth.loginin.navigation.InjectableNavigatableLoginInView
import com.niksob.domain.model.LoginData

open class LoginInViewWithLoginComponent : InjectableMVVMLoginInView() {

    protected lateinit var emailEditText: EditText
    protected lateinit var passwordEditText: EditText

    protected lateinit var loginInBtn: AppCompatButton

    protected val loginData
        get() = LoginData(
            email = emailEditText.text.toString(),
            password = passwordEditText.text.toString()
        )

    override fun initComponents() {
        super.initComponents()

        emailEditText = rootView.findViewById(R.id.login_in_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_in_view__password_et)

        loginInBtn = rootView.findViewById(R.id.login_in_view___login_in_button)
        loginInBtn.setOnClickListener { onClickLoginInBtn() }
    }

    protected open fun onClickLoginInBtn() = doLoginIn(loginData)
}