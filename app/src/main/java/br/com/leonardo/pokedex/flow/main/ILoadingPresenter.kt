package br.com.leonardo.pokedex.flow.main

import androidx.lifecycle.LiveData

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

interface ILoadingPresenter {

    fun showLoading(): ILoadingPresenter
    fun hideLoading(): ILoadingPresenter
    fun loading(): LiveData<Boolean>
    fun loadingState(): Boolean
}