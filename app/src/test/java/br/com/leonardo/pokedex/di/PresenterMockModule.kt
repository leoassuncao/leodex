package br.com.leonardo.pokedex.di

import br.com.leonardo.pokedex.flow.main.ILoadingPresenter
import br.com.leonardo.pokedex.flow.main.LoadingPresenter
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

@FlowPreview
val presenterMockModule = module {

    single { LoadingPresenter() as ILoadingPresenter }
}