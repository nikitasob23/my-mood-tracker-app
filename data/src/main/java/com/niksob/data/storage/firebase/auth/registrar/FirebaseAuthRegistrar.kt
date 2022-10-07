package com.niksob.data.storage.firebase.auth.registrar

import com.niksob.data.base.OnCompletedAction
import com.niksob.data.provider.AuthProvider
import com.niksob.data.storage.auth.auth_registrar.AuthRegistrar
import com.niksob.data.storage.firebase.auth.auth_user_id_loader.FirebaseAuthorizedUserIdLoader
import com.niksob.domain.data.dto.LoginDataDto
import com.niksob.domain.model.Query

class FirebaseAuthRegistrar(
    authProvider: AuthProvider,
    authOnCompletedAction: OnCompletedAction,
) : AuthRegistrar, FirebaseAuthorizedUserIdLoader(authProvider, authOnCompletedAction) {

    override fun register(request: Query) {
        val listener = getOnAuthCompletedListener(request)
        val (login, password) = request.data as LoginDataDto

        auth.createUserWithEmailAndPassword(login, password)
            .addOnCompleteListener(listener)
    }
}