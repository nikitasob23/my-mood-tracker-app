package com.niksob.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.niksob.di.component.DaggerLoginInViewModelFactoryComponent
import com.niksob.presentation.R
import com.niksob.presentation.viewmodel.LoginInViewModel
import javax.inject.Inject

class LoginInView : BaseView() {

    override val layout = R.layout.view_login_in

    private lateinit var viewModel: LoginInViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inject()

        initViewModel()

        return rootView
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginInViewModel::class.java]
    }

    private fun inject() {
        DaggerLoginInViewModelFactoryComponent.create()
            .inject(this)
    }
}