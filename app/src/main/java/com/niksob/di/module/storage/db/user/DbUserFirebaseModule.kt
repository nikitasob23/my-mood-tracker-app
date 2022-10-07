package com.niksob.di.module.storage.db.user

import com.niksob.data.provider.ResponseReasonProvider
import com.niksob.data.storage.firebase.base.provider.UserFirebaseRefProvider
import com.niksob.data.storage.firebase.base.saver.FirebaseSaver
import com.niksob.data.storage.firebase.base.saver.BaseFirebaseSaver
import com.niksob.data.storage.firebase.base.saver.OnDataSavedAction
import com.niksob.data.storage.firebase.base.saver.BaseOnDataSavedAction
import com.niksob.data.storage.firebase.user.SavableDbUserFirebase
import com.niksob.data.storage.firebase.user.reason.UserSaveResponseReasonProvider
import com.niksob.data.storage.provider.AppStringStorage
import com.niksob.data.storage.base.user.UserStorage
import com.niksob.di.module.storage.string.StringStorageModule
import dagger.Module
import dagger.Provides

@Module(includes = [StringStorageModule::class])
class DbUserFirebaseModule {
    @Provides
    fun provideDbUserStorage(
        dbProvider: UserFirebaseRefProvider,
        saver: FirebaseSaver
    ): UserStorage =
        SavableDbUserFirebase(dbProvider, saver)

    @Provides
    fun provideSaver(onDataSavedAction: OnDataSavedAction): FirebaseSaver = BaseFirebaseSaver(onDataSavedAction)

    @Provides
    fun provideOnCompletedAction(reasonProvider: ResponseReasonProvider): OnDataSavedAction =
        BaseOnDataSavedAction(reasonProvider)

    @Provides
    fun provideResponseReasonProvider(stringStorage: AppStringStorage): ResponseReasonProvider =
        UserSaveResponseReasonProvider(stringStorage)

    @Provides
    fun provideDbProvider() = UserFirebaseRefProvider()
}