package com.niksob.app.viewmodel.auth.loginin.validation

import com.niksob.app.viewmodel.auth.loginin.base.BaseLoginInViewModel
import com.niksob.data.provider.AppStringProvider
import com.niksob.domain.model.LoginData
import com.niksob.domain.model.Query
import com.niksob.domain.usecase.auth.LoginInWithEmailAndPasswordUseCase
import com.niksob.domain.usecase.auth.ValidateEmailUseCase
import com.niksob.domain.usecase.auth.ValidatePasswordUseCase

private const val FAILED_REASON = "registration_failed"

open class LoginInViewModelWithValidation(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    protected val stringProvider: AppStringProvider,
    loginInWithEmailAndPasswordUseCase: LoginInWithEmailAndPasswordUseCase,
) : BaseLoginInViewModel(loginInWithEmailAndPasswordUseCase) {

    override fun doLoginIn(loginData: LoginData) {
        if (validateEmailUseCase.execute(loginData.email)
            && validatePasswordUseCase.execute(loginData.password)
        ) {
            mutableResponse.value = getFailedResponse(loginData)
            return
        }
        super.doLoginIn(loginData)
    }

    private fun getFailedResponse(loginData: LoginData) =
        Query(
            data = loginData,
            reason = stringProvider.getString(FAILED_REASON)
        )
}