package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.api.PokedexApi
import com.google.gson.Gson
import io.mockk.mockk
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

val apiMockModule = module {
    single {
        mockk<PokedexApi>()
    }

    // Gson
    single {
        mockk<Gson>()
    }
}