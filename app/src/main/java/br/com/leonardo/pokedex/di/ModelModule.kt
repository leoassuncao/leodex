package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.api.model.Pokemon
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/


val modelModule = module {
    factory { Pokemon() }

}