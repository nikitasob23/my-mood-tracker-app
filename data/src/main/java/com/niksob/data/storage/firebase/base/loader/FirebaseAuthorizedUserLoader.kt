package com.niksob.data.storage.firebase.base.loader

import com.niksob.data.model.OnDataLoadedAction
import com.niksob.domain.data.dto.UidDto

interface FirebaseAuthorizedUserLoader {
    fun load(onDataLoadedAction: OnDataLoadedAction<UidDto>)
}