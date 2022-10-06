package com.niksob.data.storage.firebase.auth.signout.data_loaded_action

import com.niksob.data.storage.firebase.auth.authorizer.data_loaded_action.AuthorizerOnCompletedAction
import com.niksob.data.storage.firebase.auth.signout.response.SignOutResponseReasonProvider

open class SignOutOnCompletedAction(
    reasonProvider: SignOutResponseReasonProvider,
) : AuthorizerOnCompletedAction(reasonProvider)