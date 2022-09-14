package com.niksob.di.module.view.auth.signup

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [SignUpViewWithAuthObserverModule::class])
class SignUpViewWithAdditionUserObserverModule(
    private val userAdditionQuery: Observer<Query>,
    private val lifecycleOwner: LifecycleOwner,
) {
    @Provides
    fun provideViewModelWithAdditionUserObserver(
        @Named("sign_up_view_model_with_auth_observer") viewModel: SignUpViewModel,
    ): SignUpViewModel {
        viewModel.userAdditionQuery.observe(lifecycleOwner, userAdditionQuery)
        return viewModel
    }
}