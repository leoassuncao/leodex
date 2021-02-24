package br.com.leonardo.pokedex.flow.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class LoadingPresenter : ILoadingPresenter {
    private var isLoading = false
    private var isLoadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun showLoading(): ILoadingPresenter = apply {
        isLoading = true
        this.isLoadingMutableLiveData.value = isLoading
    }

    override fun hideLoading(): ILoadingPresenter = apply {
        isLoading = false
        this.isLoadingMutableLiveData.value = isLoading
    }

    override fun loadingState(): Boolean = isLoading

    override fun loading(): LiveData<Boolean> = isLoadingMutableLiveData
}