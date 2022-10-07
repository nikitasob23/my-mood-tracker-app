package com.niksob.data.storage.base.auth.signout

import com.niksob.data.storage.base.auth.authorizer.Authorizer
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface SignOutMaker : Authorizer {
    fun signOut(callback: Callback<Query>)
}
