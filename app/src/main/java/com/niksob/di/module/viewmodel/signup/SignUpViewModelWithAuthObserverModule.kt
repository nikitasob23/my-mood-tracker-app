package com.niksob.di.module.viewmodel.signup

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewModelModule::class])
class SignUpViewModelWithAuthObserverModule(
    private val authObserver: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    @Named("sign_up_view_model_with_auth_observer")
    fun provideViewModelWithAuthObserver(
        @Named("sign_up_view_model") viewModel: SignUpViewModel
    ): SignUpViewModel {
        viewModel.authResponse.observe(lifecycleOwner, authObserver)
        return viewModel
    }
}