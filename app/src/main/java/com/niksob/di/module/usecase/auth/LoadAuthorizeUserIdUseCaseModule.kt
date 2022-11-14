package com.niksob.di.module.usecase.auth

import com.niksob.data.converter.UserIdDtoConverter
import com.niksob.di.module.converter.UserIdDtoConverterModule
import com.niksob.di.module.repository.auth.AuthRepositoryModule
import com.niksob.domain.data.repository.auth.AuthRepositoryWithAuthorizedUserIdLoader
import com.niksob.domain.data.repository.auth.observable.AuthRepository
import com.niksob.domain.usecase.auth.loading_auth_user.LoadAuthorizeUserIdUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [
    AuthRepositoryModule::class,
    UserIdDtoConverterModule::class,
])
class LoadAuthorizeUserIdUseCaseModule {

    @Provides
    fun provideLoadAuthorizeUserIdUseCase(repo: AuthRepositoryWithAuthorizedUserIdLoader) =
        LoadAuthorizeUserIdUseCase(repo)

    @Provides
    fun provideLoadObservableAuthorizeUserIdUseCase(repo: AuthRepository, userIdConverter: UserIdDtoConverter) =
        com.niksob.domain.usecase.auth.loading_auth_user.observation.LoadAuthorizeUserIdUseCase(repo, userIdConverter)
}