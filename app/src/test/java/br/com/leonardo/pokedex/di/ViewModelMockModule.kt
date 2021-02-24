package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.flow.pokemonDetail.PokemonDetailViewModel
import br.com.leonardo.pokedex.flow.pokemonList.MainViewModel
import io.mockk.mockk
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

val viewModelMockModule = module {

    viewModel {MainViewModel(mockk())
    }
    viewModel { PokemonDetailViewModel(mockk()) }
}