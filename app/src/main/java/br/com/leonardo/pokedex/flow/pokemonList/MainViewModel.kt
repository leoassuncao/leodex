package br.com.leonardo.pokedex.flow.pokemonList

import androidx.lifecycle.*
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.service.IPokedexService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class MainViewModel (
    private val pokedexService: IPokedexService
): ViewModel(), LifecycleObserver {

    private val _pokemonResponse: MutableLiveData<List<Pokemon>>? = MutableLiveData()
    val pokemonResponse: LiveData<List<Pokemon>>? = _pokemonResponse

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val pokemon = pokedexService.getAllPokemon()
                _pokemonResponse?.postValue(pokemon)
            } catch (t: Throwable) {

                withContext(Dispatchers.Main) {
                }
            }
        }
    }

}