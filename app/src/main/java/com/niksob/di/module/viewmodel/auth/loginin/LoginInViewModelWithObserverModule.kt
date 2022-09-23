package com.niksob.di.module.viewmodel.auth.loginin

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.loginin.base.LoginInViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [LoginInViewModelModule::class])
class LoginInViewModelWithObserverModule(
    private val lifecycleOwner: LifecycleOwner,
    private val loginInViewModelObserver: Observer<Query>,
) {
    @Provides
    fun provideLoginInViewModelWithObserver(
        @Named("login_in_view_model") viewModel: LoginInViewModel
    ): LoginInViewModel {
        viewModel.response.observe(lifecycleOwner, loginInViewModelObserver)
        return viewModel
    }
}