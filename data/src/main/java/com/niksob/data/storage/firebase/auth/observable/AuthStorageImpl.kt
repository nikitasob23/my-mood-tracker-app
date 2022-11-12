package com.niksob.data.storage.firebase.auth.observable

import com.niksob.data.storage.base.auth.observable.AuthStorage
import com.niksob.data.storage.firebase.base.loader.FirebaseAuthorizedUserLoader
import com.niksob.data.storage.firebase.base.loader.observation.BaseObservableStorage
import com.niksob.domain.data.dto.UidDto
import io.reactivex.Single

class AuthStorageImpl(
    private val loader: FirebaseAuthorizedUserLoader,
) : AuthStorage, BaseObservableStorage() {

    override fun loadAuthorizeUserId() =
        Single.create<UidDto> { emitter ->
            val callback = onDataLoadedAction(emitter)
            loader.load(callback)
        }
}