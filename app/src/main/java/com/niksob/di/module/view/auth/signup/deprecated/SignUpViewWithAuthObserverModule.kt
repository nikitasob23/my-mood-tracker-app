package com.niksob.di.module.view.auth.signup.deprecated

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.signup.base.SignUpViewModelWithNewUserAddition
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
        @Named("sign_up_view_model") viewModel: SignUpViewModelWithNewUserAddition
    ): SignUpViewModelWithNewUserAddition {
        viewModel.authResponse.observe(lifecycleOwner, authObserver)
        return viewModel
    }
}