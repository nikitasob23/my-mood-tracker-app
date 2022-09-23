package com.niksob.di.module.viewmodel.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.niksob.app.viewmodel.main.MainActivityViewModel
import com.niksob.domain.model.Query
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [MainActivityViewModelModule::class])
class MainActivityViewModelWithObserverModule(
    private val lifecycleOwner: LifecycleOwner,
    private val authUserResponseObserver: Observer<Query>,
    private val signOutResponseObserver: Observer<Query>,
) {
    @Provides
    fun provideViewModelWithObservers(
        @Named("main_activity_view_model") viewModel: MainActivityViewModel
    ): MainActivityViewModel {
        viewModel.loadAuthUserResponse.observe(lifecycleOwner, authUserResponseObserver)
        viewModel.signOutResponse.observe(lifecycleOwner, signOutResponseObserver)
        return viewModel
    }
}