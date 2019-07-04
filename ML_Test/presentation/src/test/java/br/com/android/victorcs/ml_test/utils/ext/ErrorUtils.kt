package br.com.android.victorcs.ml_test.utils.ext

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorUtils {

    fun createHttpException(
        statusCode: Int,
        developerMessage: String = "error - A culpa é do backend"
    ): HttpException {

        val apiError = Throwable(
            message = developerMessage
        )

        val response = Response.error<HttpException>(
            statusCode,
            ResponseBody.create(
                MediaType.parse("application/json"),
                Gson().toJson(apiError)
            )
        )

        return HttpException(response)
    }

    fun isNetworkError(error: Throwable): Boolean {
        return (error is SocketTimeoutException || error is UnknownHostException
                || error is IOException && error.message?.contentEquals("Canceled") == true)
    }

    private fun getNetworkErrors() =
        listOf<Throwable>(UnknownHostException(), SocketTimeoutException(), IOException("Canceled"))

    fun getKnownErrors(): MutableList<Throwable> {
        val errors = mutableListOf<Throwable>(
            createHttpException(statusCode = 400),
            createHttpException(statusCode = 401),
            createHttpException(statusCode = 403),
            createHttpException(statusCode = 404),
            createHttpException(statusCode = 500)
        )
        errors.addAll(getNetworkErrors())
        return errors
    }

    fun getErrorDescription(error: Throwable): String {
        return "${error.javaClass.simpleName} ${(error as? HttpException)?.code()
            ?: ""}"
    }
}