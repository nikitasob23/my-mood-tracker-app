package com.niksob.di.module.view.auth.signup.deprecated

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.signup.base.signup.SignUpViewModel
import com.niksob.app.viewmodel.auth.signup.base.useraddition.SignUpViewModelWithNewUserAddition
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewWithAuthObserverModule::class])
class SignUpViewWithNewAdditionUserObserverModule(
    private val userAdditionQuery: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    @Named("view_model_with_user_addition_observer")
    fun provideViewModelWithAdditionUserObserver(
        @Named("sign_up_view_model_with_auth_observer") viewModel: SignUpViewModelWithNewUserAddition,
    ): SignUpViewModel {
        viewModel.userAdditionResponse.observe(lifecycleOwner, userAdditionQuery)
        return viewModel
    }
}