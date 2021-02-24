package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
    }

    // OkHttp Client
    single {
        OkHttpClient.Builder()
            .build()
    }

    // Gson
    single {
        GsonBuilder().create()
    }

    // GsonConverterFactory
    single {
        GsonConverterFactory.create(get()) as Converter.Factory
    }
}