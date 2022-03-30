package com.niksob.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.di.component.DaggerSignUpViewComponent
import com.niksob.di.module.view.login.SignUpViewModule
import com.niksob.di.module.app.ContextModule
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.model.LoginData
import com.niksob.presentation.R
import com.niksob.presentation.viewmodel.SignUpViewModel
import javax.inject.Inject

class SignUpView : BaseView() {
    override val layout = R.layout.sign_up_view

    @Inject
    lateinit var viewModel: SignUpViewModel

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()
        initViewModelObserver()
        initComponents()

        return rootView
    }

    private fun inject() {
        DaggerSignUpViewComponent.builder()
            .contextModule(ContextModule(context = requireContext().applicationContext))
            .signUpViewModule(SignUpViewModule(viewModelStoreOwner = this))
            .build()
            .inject(this)
    }

    private fun initViewModelObserver() {
        viewModel.response.observe(viewLifecycleOwner) { authResponse ->
            Log.d(this@SignUpView.javaClass.simpleName, "Registration: success = ${authResponse.success}; "
                    + "reason = ${authResponse.reason}")

            makeAuthStatusToast(authResponse)

            progressBar?.hideProgress()

            if (authResponse.success) {
                navigation?.goToNextView(EntriesView())
            }
        }
    }

    private fun makeAuthStatusToast(authResponse: AuthResponse) {
        Toast.makeText(activity?.applicationContext, authResponse.reason, Toast.LENGTH_SHORT).show()
    }

    private fun initComponents() {
        emailEditText = rootView.findViewById(R.id.sign_up_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_up_view__password_et)

        rootView.findViewById<AppCompatButton>(R.id.sign_up_view___login_up_button).setOnClickListener {
            progressBar?.showProgress()

            val loginData = LoginData(
                email = emailEditText.text.toString(),
                password = passwordEditText.text.toString()
            )
            viewModel.doLoginUp(loginData)
        }
    }
}