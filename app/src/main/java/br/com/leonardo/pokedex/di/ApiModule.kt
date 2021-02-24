package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.api.PokedexApi
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

val apiModule = module {
    // Pokedex
    single {
        get<Retrofit>().create(PokedexApi::class.java)
    }

}