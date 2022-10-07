package com.niksob.di.module.viewmodel.user.factory

import androidx.lifecycle.ViewModelProvider
import com.niksob.app.viewmodel.user.factory.UserAdditionViewModelFactory
import com.niksob.di.module.usecase.AddUserUseCaseModule
import com.niksob.domain.usecase.db.AddUserUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [AddUserUseCaseModule::class])
class UserAdditionViewModelFactoryModule {
    @Provides
    @Named("user_addition_view_model_factory")
    fun provideViewModelFactory(addUserUseCase: AddUserUseCase): ViewModelProvider.Factory =
        UserAdditionViewModelFactory(addUserUseCase)
}