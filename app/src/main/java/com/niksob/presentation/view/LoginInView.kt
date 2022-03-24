package com.niksob.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.niksob.di.component.DaggerLoginInViewModelFactoryComponent
import com.niksob.domain.model.AuthResponse
import com.niksob.domain.model.LoginData
import com.niksob.presentation.R
import com.niksob.presentation.viewmodel.LoginInViewModel
import javax.inject.Inject

class LoginInView : BaseView() {

    override val layout = R.layout.view_login_in

    private lateinit var viewModel: LoginInViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()
        initViewModel()
        initComponents()

        return rootView
    }

    private fun inject() {
        DaggerLoginInViewModelFactoryComponent.create()
            .inject(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginInViewModel::class.java]
        viewModel.response.observe(viewLifecycleOwner) { authResponse ->
            Log.d(this@LoginInView.javaClass.simpleName, "Authorize: success = ${authResponse.success}; "
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
        emailEditText = rootView.findViewById(R.id.login_in_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_in_view__password_et)

        rootView.findViewById<AppCompatButton>(R.id.login_in_view___login_in_button).setOnClickListener {
            progressBar?.showProgress()

            val loginData = LoginData(
                email = emailEditText.text.toString(),
                password = passwordEditText.text.toString()
            )
            viewModel.doLoginIn(loginData)
        }
    }
}

