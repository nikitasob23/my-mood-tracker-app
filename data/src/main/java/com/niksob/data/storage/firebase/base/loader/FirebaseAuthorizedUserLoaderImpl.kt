package com.niksob.data.storage.firebase.base.loader

import com.niksob.data.model.OnDataLoadedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.domain.data.dto.UidDto
import java.lang.IllegalStateException

class FirebaseAuthorizedUserLoaderImpl(
    private val authProvider: AuthProvider,
) : FirebaseAuthorizedUserLoader {

    override fun load(onDataLoadedAction: OnDataLoadedAction<UidDto>) {
        if (authProvider.auth.currentUser == null) {

            val exception = IllegalStateException()
            onDataLoadedAction.onDataCancelled(exception)
            return
        }
        val currentUser = authProvider.auth.currentUser!!
        val uidDto = UidDto(currentUser.uid)
        onDataLoadedAction.onDataLoaded(uidDto)
    }
}