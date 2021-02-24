package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.service.IPokedexService
import br.com.leonardo.pokedex.service.PokedexService
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

val serviceModule = module {
    //Session
    single { PokedexService(get(), get()) as IPokedexService }

}