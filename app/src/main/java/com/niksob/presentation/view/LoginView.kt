package com.niksob.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.niksob.presentation.R
import javax.inject.Inject

class LoginView @Inject constructor() : BaseView() {

    override val layout = R.layout.login_view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        initComponents()

        return rootView
    }

    private fun initComponents() {
        rootView.findViewById<AppCompatButton>(R.id.login_view__login_in_button).setOnClickListener {
            navigation?.goToNextView(LoginInView())
        }
        rootView.findViewById<AppCompatButton>(R.id.login_view__sign_up_button).setOnClickListener {
            navigation?.goToNextView(SignUpView())
        }
    }
}