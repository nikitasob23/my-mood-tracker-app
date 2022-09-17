package com.niksob.di.module.view.auth.loginin

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.app.viewmodel.auth.loginin.LoginInViewModel
import com.niksob.app.viewmodel.auth.loginin.deprecated.LoginInViewModelImpl
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.factory.loginin.LoginInViewModelFactoryModule
import com.niksob.domain.model.NavigationableScreenClass
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        LoginInViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class LoginInViewModelModule {
    @Provides
    @Named("login_in_view_model")
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClassImpl: Class<LoginInViewModelImpl>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): LoginInViewModel =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClassImpl]

    @Provides
    fun provideViewModelClass() = LoginInViewModelImpl::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass() =
        NavigationableScreenClass(InjectedMoodEntriesListView::class.java)
}