package br.com.leonardo.pokedex.extensions

import com.google.gson.Gson
import timber.log.Timber
import java.io.Reader

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

inline fun <reified T> Gson.fromJsonOrNull(json: String): T? {
    return try {
        fromJson(json, T::class.java)
    } catch (t: Throwable) {
        Timber.e(t)
        null
    }
}

inline fun <reified T> Gson.fromJsonOrNull(json: Reader): T? {
    return try {
        fromJson(json, T::class.java)
    } catch (t: Throwable) {
        Timber.e(t)
        null
    }
}

fun Any.toJson(): String = Gson().toJson(this)
