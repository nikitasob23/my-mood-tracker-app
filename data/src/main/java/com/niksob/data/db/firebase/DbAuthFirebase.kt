package com.niksob.data.db.firebase

import com.google.firebase.auth.FirebaseAuth
import com.niksob.data.db.DbAuthStorage
import com.niksob.domain.data.dto.AuthResponseDto
import com.niksob.domain.data.dto.LoginDataDto

const val SUCCESS_REASON = "Completed"
const val FAILED_REASON = "Failed"

class DbAuthFirebase(
    private val auth: FirebaseAuth
) : DbAuthStorage {
    override fun authorize(loginData: LoginDataDto): AuthResponseDto {

        var response: AuthResponseDto? = null

        auth.signInWithEmailAndPassword(loginData.email, loginData.password).addOnCompleteListener {
            response = AuthResponseDto(
                success = true,
                reason = SUCCESS_REASON
            )
        }.addOnCanceledListener {
            response = AuthResponseDto(
                success = false,
                reason = FAILED_REASON
            )
        }
        return response!!
    }
}