package com.niksob.app.viewmodel.auth.signup.validation

import com.niksob.app.viewmodel.auth.signup.base.BaseSignUpViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.sign_up.SignUpWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.validation.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.validation.ValidatePasswordUseCase

private const val FAILED_REASON = "registration_failed"

open class SignUpViewModelWithLoginDataValidation(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val stringProvider: AppStringProvider,
    signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
) : BaseSignUpViewModel(signUpWithEmailAndPasswordUseCase) {

    override fun doSignUp(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email)
            && validatePasswordUseCase.execute(loginData.password)
        ) {
            val failureResponse = getFailureResponse(loginData)
            onSignUpCompleted(failureResponse)
            return
        }
        super.doSignUp(loginData)
    }

    private fun getFailureResponse(loginData: LoginData) =
        Query(
            data = loginData,
            reason = stringProvider.getString(FAILED_REASON)
        )
}