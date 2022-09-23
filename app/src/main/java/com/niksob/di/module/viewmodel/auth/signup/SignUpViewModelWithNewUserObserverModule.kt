package com.niksob.di.module.viewmodel.auth.signup

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.signup.base.signup.SignUpViewModel
import com.niksob.app.viewmodel.auth.signup.base.useraddition.SignUpViewModelWithNewUserAddition
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewModelWithAuthObserverModule::class])
class SignUpViewModelWithNewUserObserverModule(
    private val lifecycleOwner: LifecycleOwner,
    private val userAdditionObserver: Observer<Query>,
) {
    @Provides
    fun provideViewModel(
        @Named("sign_up_view_model_with_auth_observer") viewModel: SignUpViewModel,
    ): SignUpViewModel {
        viewModel as SignUpViewModelWithNewUserAddition
        viewModel.userAdditionResponse.observe(lifecycleOwner, userAdditionObserver)
        return viewModel
    }
}