package com.niksob.di.module.view.auth.loginin

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.auth.loginin.LoginInViewModel
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
    @Named("login_in_view_model_with_observer")
    fun provideLoginInViewModelWithObserver(viewModel: LoginInViewModel): LoginInViewModel {
        viewModel.query.observe(lifecycleOwner, loginInViewModelObserver)
        return viewModel
    }
}