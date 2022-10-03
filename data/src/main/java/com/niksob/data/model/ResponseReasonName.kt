package com.niksob.data.model

enum class ResponseReasonName(val value: String) {
    SUCCESS_AUTH_USER_ID_LOAD("success_auth_user_id_loading"),
    FAILURE_AUTH_USER_ID_LOAD("failure_auth_user_id_loading"),
    SUCCESS_AUTH_REASON("authorize_completed"),
    FAILED_AUTH_REASON("authorize_failed"),
    SUCCESS_REGISTER_REASON("registration_completed"),
    FAILED_REGISTER_REASON("registration_failed"),
    SUCCESS_SIGN_OUT_REASON("sign_out_completed"),
    FAILED_SIGN_OUT_REASON("sign_out_failed"),
}