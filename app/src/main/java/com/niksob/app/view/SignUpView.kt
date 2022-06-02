package com.niksob.app.view

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
import com.niksob.domain.model.User
import com.niksob.domain.model.LoginData
import com.niksob.app.R
import com.niksob.app.viewmodel.SignUpViewModel
import javax.inject.Inject

class SignUpView : BaseView() {

    override val layout = R.layout.sign_up_view

    @Inject
    lateinit var viewModel: SignUpViewModel

    @Inject
    lateinit var signOutTestViewClass: Class<SignOutTestView>

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private var userEmail = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()
        initComponents()
        initViewModelObservers()

        return rootView
    }

    private fun inject() {
        DaggerSignUpViewComponent.builder()
            .contextModule(ContextModule(context = requireContext().applicationContext))
            .signUpViewModule(SignUpViewModule(viewModelStoreOwner = this))
            .build()
            .inject(this)
    }

    private fun initViewModelObservers() {
        initAuthResponseObserver()
        initAdditionUserResponseObserver()
    }

    private fun initAuthResponseObserver() {
        viewModel.authQuery.observe(viewLifecycleOwner) { query ->
            Log.d(this@SignUpView.javaClass.simpleName, "Registration: success = ${query.completed}; "
                        + "reason = ${query.reason}")

            if (!query.completed) {
                onCanceledLoadData(query.reason)
                return@observe
            }

            makeAuthStatusToast(query.reason)

            val user = User(
                id = query.data as String,
                email = userEmail,
            )

            viewModel.addUser(user)

            navigation?.goToNextView(signOutTestViewClass)
            progressBar?.hideProgress()
        }
    }

    private fun initAdditionUserResponseObserver() {
        viewModel.userAdditionQuery.observe(viewLifecycleOwner) { query ->
            Log.d(this@SignUpView.javaClass.simpleName, "Addition user: success = ${query.completed}; "
                        + "reason = ${query.reason}")

            if (!query.completed) {
                onCanceledLoadData(query.reason)
                return@observe
            }

            progressBar?.hideProgress()
        }
    }

    private fun makeAuthStatusToast(text: String) {
        Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    private fun initComponents() {
        emailEditText = rootView.findViewById(R.id.sign_up_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_up_view__password_et)

        rootView.findViewById<AppCompatButton>(R.id.sign_up_view___login_up_button).setOnClickListener {
            progressBar?.showProgress()

            userEmail = emailEditText.text.toString()

            val loginData = LoginData(
                email = userEmail,
                password = passwordEditText.text.toString()
            )
            viewModel.doLoginUp(loginData)
        }
    }

    private fun onCanceledLoadData(toastText: String) {
        makeAuthStatusToast(toastText)
        userEmail = ""
        progressBar?.hideProgress()
    }
}