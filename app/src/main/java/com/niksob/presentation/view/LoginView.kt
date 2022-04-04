package com.niksob.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.login.LoginViewModule
import com.niksob.di.component.DaggerLoginViewComponent
import com.niksob.domain.model.login.AuthResponse
import com.niksob.presentation.R
import com.niksob.presentation.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginView : BaseView() {

    override val layout = R.layout.login_view

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        progressBar?.showProgress()

        inject()

        initComponents()

        initViewModelObserver()

        viewModel.loadAuthorizeUserId()

        return rootView
    }

    private fun inject() {
        DaggerLoginViewComponent.builder()
            .contextModule(ContextModule(context = requireContext().applicationContext))
            .loginViewModule(LoginViewModule(viewModelStoreOwner = this))
            .build()
            .inject(this)
    }

    private fun initComponents() {
        rootView.findViewById<AppCompatButton>(R.id.login_view__login_in_button).setOnClickListener {
            navigation?.goToNextView(LoginInView())
        }
        rootView.findViewById<AppCompatButton>(R.id.login_view__sign_up_button).setOnClickListener {
            navigation?.goToNextView(SignUpView())
        }
    }

    private fun initViewModelObserver() {
        viewModel.response.observe(viewLifecycleOwner) { authResponse ->
            Log.d(this@LoginView.javaClass.simpleName, "Authorize: success = ${authResponse.success}; "
                    + "reason = ${authResponse.reason}")

            makeAuthStatusToast(authResponse)

            if (authResponse.success) {
                navigation?.goToNextView(EntriesView(uid = authResponse.uid!!))
            }

            progressBar?.hideProgress()
        }
    }

    private fun makeAuthStatusToast(authResponse: AuthResponse) {
        Toast.makeText(activity?.applicationContext, authResponse.reason, Toast.LENGTH_SHORT).show()
    }
}