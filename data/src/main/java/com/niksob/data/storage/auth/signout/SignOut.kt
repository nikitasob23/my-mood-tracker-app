package com.niksob.data.storage.auth.signout

import com.niksob.data.storage.auth.authorizer.Authorizer
import com.niksob.domain.model.Callback
import com.niksob.domain.model.Query

interface SignOut : Authorizer {
    fun signOut(callback: Callback<Query>)
}
