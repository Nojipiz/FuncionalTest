package com.test.gse.common

sealed class Problem(val throwable:Throwable? = null, val message: String? = null) {
    class ConnectionError(message: String? = null, throwable: Throwable?): Problem(message = message, throwable = throwable)
    class OtherError(throwable: Throwable?): Problem(throwable = throwable)
}

fun Problem?.getMessage() =
    this?.message ?:
    this?.throwable?.message
    ?: "Unknown Error"