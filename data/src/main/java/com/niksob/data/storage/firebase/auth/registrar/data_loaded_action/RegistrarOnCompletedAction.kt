package com.niksob.data.storage.firebase.auth.registrar.data_loaded_action

import com.niksob.data.storage.firebase.auth.auth_user_id_loader.data_loaded_action.AuthUserIdOnCompletedAction
import com.niksob.data.storage.firebase.auth.registrar.reason.RegistrarReasonResponseProvider

class RegistrarOnCompletedAction(
    reasonProvider: RegistrarReasonResponseProvider
) : AuthUserIdOnCompletedAction(reasonProvider)