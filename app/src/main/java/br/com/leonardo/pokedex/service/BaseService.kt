package br.com.leonardo.pokedex.service

import android.util.Log
import br.com.leonardo.pokedex.ResponseMalFormattedThrowable
import br.com.leonardo.pokedex.extensions.fromJsonOrNull
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.Response
import timber.log.Timber

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

abstract class BaseService(
    private val gson: Gson
) {

    companion object {
        const val UNKNOWN_ERROR =
            "Hubo un error inesperado. Por favor, póngase en contacto con el soporte técnico."
    }


    protected fun <T> handleResponse(response: Response<T>): T? {
        try {
            if (response.isSuccessful) {
                Log.e("erro", "erro")
                return response.body()
            } else {
                Log.e("erro", "erro2")

                Timber.e(UNKNOWN_ERROR)

                throw ResponseMalFormattedThrowable(UNKNOWN_ERROR)
            }
        } catch (t: JsonSyntaxException) {
            throw ResponseMalFormattedThrowable(UNKNOWN_ERROR)
        } catch (t: NoSuchElementException) {
            throw ResponseMalFormattedThrowable(UNKNOWN_ERROR)
        } catch (t: IllegalStateException) {
            throw ResponseMalFormattedThrowable(UNKNOWN_ERROR)
        }
    }
}