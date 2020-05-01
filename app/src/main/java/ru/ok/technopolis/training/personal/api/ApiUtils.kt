package ru.ok.technopolis.training.personal.api

import android.util.Base64

object ApiUtils {

    fun encodeEmailAndPasswordToAuthorizationHeader(email: String, password: String): String =
            "Basic${Base64.encodeToString(("$email:$password").toByteArray(), Base64.DEFAULT)}"
}