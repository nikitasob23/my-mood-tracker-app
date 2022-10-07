package com.niksob.app.view.auth.signup.uicomponent

import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.niksob.app.R
import com.niksob.app.view.auth.signup.viewmodel.useraddition.InjectableMVVMSignUpWithUserAdderView
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.model.Uid
import com.niksob.domain.model.User
import java.lang.IllegalStateException

open class SignUpViewWithSignUpComponent : InjectableMVVMSignUpWithUserAdderView() {

    protected lateinit var emailEditText: EditText
    protected lateinit var passwordEditText: EditText

    protected lateinit var signUpBtn: AppCompatButton

    protected var userEmail = ""

    override fun initComponents() {
        super.initComponents()

        emailEditText = rootView.findViewById(R.id.sign_up_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_up_view__password_et)

        signUpBtn = rootView.findViewById(R.id.sign_up_view___login_up_button)
        signUpBtn.setOnClickListener { doSignUp() }
    }

    protected fun doSignUp() {
        userEmail = emailEditText.text.toString()

        val loginData = LoginData(
            email = userEmail,
            password = passwordEditText.text.toString()
        )
        super.doSignUp(loginData)
    }

    override fun onSignUpCompleted(response: Query) {

        if (!response.completed) {
            throw IllegalStateException()
        }

        val user = User(
            id = response.data as Uid,
            email = userEmail,
        )
        addUser(user)
    }
}