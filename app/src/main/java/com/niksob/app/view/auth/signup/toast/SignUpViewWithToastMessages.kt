package com.niksob.app.view.auth.signup.toast

import com.niksob.app.R
import com.niksob.app.toast.ToastMessage
import com.niksob.app.view.auth.signup.progressbar.InjectedSignUpViewWithProgressbar
import com.niksob.domain.model.Query
import javax.inject.Inject

open class SignUpViewWithToastMessages : InjectedSignUpViewWithProgressbar() {
    @Inject
    lateinit var toastMessage: ToastMessage

    private val authCompletedMessage get() = requireContext().getString(R.string.registration_completed)

    private val authFailedMessage get() = requireContext().getString(R.string.registration_failed)

    private val signOutMessage get() = requireContext().getString(R.string.sign_out)

    protected open fun showAuthCompletedMessage() = toastMessage.showShortToast(authCompletedMessage)

    protected open fun showAuthFailedMessage() = toastMessage.showShortToast(authFailedMessage)

    protected open fun showSignOutMessage() = toastMessage.showShortToast(signOutMessage)

    override fun onSignUpCompleted(response: Query) {
        super.onSignUpCompleted(response)

        if (response.completed) {
            showAuthCompletedMessage()
        } else {
            showAuthFailedMessage()
        }
    }

    override fun moveToPreviousScreen() {
        super.moveToPreviousScreen()
        showSignOutMessage()
    }
}