package com.niksob.app.view.auth.loginin.deprecated

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.view.auth.loginin.LoginInViewModelWithViewModelStoreOwnerModule
import com.niksob.domain.model.LoginData
import com.niksob.app.R
import com.niksob.app.view.main.activity.base.BaseView
import com.niksob.app.viewmodel.auth.loginin.deprecated.LoginInViewModelImpl
import com.niksob.di.component.view.auth.loginin.DaggerLoginInViewComponent
import com.niksob.domain.navigation.NavigationableScreen
import javax.inject.Inject
import javax.inject.Named

open class LoginInView : BaseView() {

    override val layout = R.layout.login_in_view

    @Inject
    lateinit var viewModel: LoginInViewModelImpl

    @Inject
    @Named("mood_entries_view_class")
    lateinit var moodEntriesViewClass: Class<out NavigationableScreen>

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()
        initViewModelObserver()
        initComponents()

        return rootView
    }

    private fun inject() {
        DaggerLoginInViewComponent.builder()
            .contextModule(ContextModule(requireContext().applicationContext))
            .loginInViewModelWithViewModelStoreOwnerModule(
                LoginInViewModelWithViewModelStoreOwnerModule(viewModelStoreOwner = this)
            )
            .build()
            .inject(this)
    }

    private fun initViewModelObserver() {
        viewModel.response.observe(viewLifecycleOwner) { query ->
            Log.d(
                this@LoginInView.javaClass.simpleName, "Authorize: success = ${query.completed}; "
                        + "reason = ${query.reason}"
            )

            makeAuthStatusToast(query.reason)

            if (query.completed) {
                navigation?.goToNextView(moodEntriesViewClass)
            }

            progressBar?.hideProgress()
        }
    }

    private fun makeAuthStatusToast(text: String) {
        Toast.makeText(activity?.applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    private fun initComponents() {
        emailEditText = rootView.findViewById(R.id.login_in_view__email_et)
        passwordEditText = rootView.findViewById(R.id.login_in_view__password_et)

        rootView.findViewById<AppCompatButton>(R.id.login_in_view___login_in_button)
            .setOnClickListener {
                progressBar?.showProgress()

                val loginData = LoginData(
                    email = emailEditText.text.toString(),
                    password = passwordEditText.text.toString()
                )
                viewModel.doLoginIn(loginData)
            }
    }
}

