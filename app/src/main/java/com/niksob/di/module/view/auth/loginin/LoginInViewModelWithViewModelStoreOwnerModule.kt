package com.niksob.di.module.view.auth.loginin

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.view.mood.entry.list.mvvm.InjectableMVVMMoodEntriesListView
import com.niksob.app.viewmodel.auth.loginin.deprecated.LoginInViewModelImpl
import com.niksob.di.module.viewmodel.factory.loginin.DeprecatedLoginInViewModelFactoryModule
import com.niksob.domain.navigation.NavigationableScreen
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [DeprecatedLoginInViewModelFactoryModule::class])
class LoginInViewModelWithViewModelStoreOwnerModule(
    private val viewModelStoreOwner: ViewModelStoreOwner,
) {
    @Provides
    fun provideLoginInViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClassImpl: Class<LoginInViewModelImpl>
    ) =
        ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClassImpl]

    @Provides
    fun provideViewModelClass() = LoginInViewModelImpl::class.java

    @Provides
    @Named("mood_entries_view_class")
    fun provideMoodEntriesViewClass(): Class<out NavigationableScreen> = InjectableMVVMMoodEntriesListView::class.java
}