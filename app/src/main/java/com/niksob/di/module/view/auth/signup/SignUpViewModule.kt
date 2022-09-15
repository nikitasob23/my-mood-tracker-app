package com.niksob.di.module.view.auth.signup

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.list.InjectedMoodEntriesListView
import com.niksob.app.viewmodel.auth.SignUpViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.viewmodel.factory.SignUpViewModelFactoryModule
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
        viewModelClass: Class<SignUpViewModel>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = SignUpViewModel::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass() =
        NavigationableScreenClass(InjectedMoodEntriesListView::class.java)
}