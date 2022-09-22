package com.niksob.app.view.auth.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.domain.model.User
import com.niksob.domain.model.LoginData
import com.niksob.app.R
import com.niksob.app.view.main.activity.base.BaseView
import com.niksob.app.viewmodel.auth.signup.deprecated.SignUpViewModelImpl
import com.niksob.domain.model.Uid
import com.niksob.domain.navigation.NavigationableScreen
import javax.inject.Inject
import javax.inject.Named

open class SignUpView : BaseView() {

    override val layout = R.layout.sign_up_view

    @Inject
    lateinit var viewModel: SignUpViewModelImpl

    @Inject
    @Named("mood_entries_view_class")
    lateinit var moodEntriesViewClass: Class<out NavigationableScreen>

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
//        DaggerSignUpViewComponent.builder()
//            .contextModule(ContextModule(context = requireContext().applicationContext))
//            .signUpViewWithViewModelStoreOwnerModule(SignUpViewWithViewModelStoreOwnerModule(viewModelStoreOwner = this))
//            .build()
//            .inject(this)
    }

    private fun initViewModelObservers() {
        initAuthResponseObserver()
        initAdditionUserResponseObserver()
    }

    private fun initAuthResponseObserver() {
        viewModel.authResponse.observe(viewLifecycleOwner) { query ->
            Log.d(this@SignUpView.javaClass.simpleName, "Registration: success = ${query.completed}; "
                        + "reason = ${query.reason}")

            if (!query.completed) {
                onCanceledLoadData(query.reason)
                return@observe
            }

            makeAuthStatusToast(query.reason)

            val user = User(
                id = query.data as Uid,
                email = userEmail,
            )

            viewModel.addUser(user)

            navigation?.goToNextView(moodEntriesViewClass)
            progressBar?.hideProgress()
        }
    }

    private fun initAdditionUserResponseObserver() {
        viewModel.userAdditionResponse.observe(viewLifecycleOwner) { query ->
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
            viewModel.doSignUp(loginData)
        }
    }

    private fun onCanceledLoadData(toastText: String) {
        makeAuthStatusToast(toastText)
        userEmail = ""
        progressBar?.hideProgress()
    }
}