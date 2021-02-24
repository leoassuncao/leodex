package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.flow.pokemonDetail.PokemonDetailViewModel
import br.com.leonardo.pokedex.flow.pokemonList.MainViewModel
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/
@FlowPreview
val viewModelModule = module {

    //Main
    viewModel { MainViewModel(get()) }

    //PokemonDetail
    viewModel { PokemonDetailViewModel(get())}
}
