package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

val modelMockModule = module {
    factory { Pokemon() }
    factory { PokemonDetail(stats = get(),types = get()) }
    factory { PokemonDetail.Types(type = get()) }
    factory { PokemonDetail.Type()}
    factory { PokemonDetail.Stats(stat = get())}
    factory { PokemonDetail.Stat() }
}