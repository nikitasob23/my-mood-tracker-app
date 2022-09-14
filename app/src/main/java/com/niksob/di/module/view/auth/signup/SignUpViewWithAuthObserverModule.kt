package com.niksob.di.module.view.auth.signup

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewModule::class])
class SignUpViewWithAuthObserverModule(
    private val authObserver: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    @Named("sign_up_view_model_with_auth_observer")
    fun provideViewModelWithAuthObserver(
        @Named("sign_up_view_model") viewModel: SignUpViewModel
    ): SignUpViewModel {
        viewModel.authQuery.observe(lifecycleOwner, authObserver)
        return viewModel
    }
}