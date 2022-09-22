package com.niksob.di.module.view.auth.signup.deprecated

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.app.viewmodel.auth.signup.base.useraddition.SignUpViewModelWithNewUserAddition
import com.niksob.app.viewmodel.auth.signup.deprecated.SignUpViewModelImpl
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.signup.factory.SignUpViewModelFactoryModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        SignUpViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class SignUpViewModule {
    @Provides
    @Named("sign_up_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<SignUpViewModelImpl>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): SignUpViewModelWithNewUserAddition =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass(): Class<SignUpViewModelImpl> = SignUpViewModelImpl::class.java

    @Provides
    fun provideMoodEntriesViewClass() =
        NavigationableScreenClass(InjectedMoodEntriesListView::class.java)
}