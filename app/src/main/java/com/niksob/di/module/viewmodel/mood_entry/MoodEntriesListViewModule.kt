package com.niksob.di.module.viewmodel.mood_entry

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.niksob.app.viewmodel.mood_entry.base.MoodEntriesListViewModel
import com.niksob.app.viewmodel.mood_entry.transfer.TransferObservableMoodEntriesListViewModel
import com.niksob.di.module.app.AppMainActivityViewModelStoreOwnerModule
import com.niksob.di.module.app.ContextModule
import com.niksob.di.module.viewmodel.mood_entry.factory.transfer.TransferObservableMoodEntriesListViewModelFactoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
    includes = [
        ContextModule::class,
//        MoodEntriesListViewModelFactoryModule::class,
        TransferObservableMoodEntriesListViewModelFactoryModule::class,
        AppMainActivityViewModelStoreOwnerModule::class,
    ]
)
class MoodEntriesListViewModule {
    @Provides
    @Named("mood_entries_view_model")
    fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory,
        viewModelClass: Class<TransferObservableMoodEntriesListViewModel>,
        viewModelStoreOwner: ViewModelStoreOwner,
    ): MoodEntriesListViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]

    @Provides
    fun provideViewModelClass() = TransferObservableMoodEntriesListViewModel::class.java

//    @Provides
//    @Named("mood_entries_view_model")
//    fun provideViewModel(
//        viewModelFactory: ViewModelProvider.Factory,
//        viewModelClass: Class<BaseMoodEntriesListViewModel>,
//        viewModelStoreOwner: ViewModelStoreOwner,
//    ): MoodEntriesListViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory)[viewModelClass]
//
//    @Provides
//    fun provideViewModelClass() = BaseMoodEntriesListViewModel::class.java
}