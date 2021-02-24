package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.service.IPokedexService
import br.com.leonardo.pokedex.service.PokedexService
import io.mockk.mockk
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

val serviceMockModule = module {
    single { PokedexService(mockk()) }

}