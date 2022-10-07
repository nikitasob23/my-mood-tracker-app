package com.niksob.di.module.viewmodel.user

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.user.UserAdditionViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [UserAdditionViewModelModule::class])
class UserAdditionViewModelWithObserverModule(
    private val lifecycleOwner: LifecycleOwner,
    private val userAdditionObserver: Observer<Query>,
) {
    @Provides
    fun provideViewModelWithObserver(
        @Named("user_addition_view_model") viewModel: UserAdditionViewModel
    ): UserAdditionViewModel {
        viewModel.userAdditionResponse.observe(lifecycleOwner, userAdditionObserver)
        return viewModel
    }
}