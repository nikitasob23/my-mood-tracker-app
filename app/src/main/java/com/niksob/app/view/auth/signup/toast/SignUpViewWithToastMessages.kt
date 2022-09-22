package com.niksob.app.view.auth.signup.toast

import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.auth.signup.progressbar.SignUpViewWithProgressbar
import com.niksob.domain.model.Query
import javax.inject.Inject

open class SignUpViewWithToastMessages : SignUpViewWithProgressbar() {
    @Inject
    lateinit var toastMessage: ToastMessage

    private val authCompletedMessage get() = requireContext().getString(R.string.registration_completed)

    private val authFailedMessage get() = requireContext().getString(R.string.registration_failed)

    protected open fun showAuthCompletedMessage() = toastMessage.showShortToast(authCompletedMessage)

    protected open fun showAuthFailedMessage() = toastMessage.showShortToast(authFailedMessage)

    override fun onSignUpCompleted(response: Query) {
        super.onSignUpCompleted(response)

        if (response.completed) {
            showAuthCompletedMessage()
        } else {
            showAuthFailedMessage()
        }
    }


}