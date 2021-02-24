package br.com.leonardo.pokedex.flow.pokemonDetail

import androidx.lifecycle.*
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail
import br.com.leonardo.pokedex.service.IPokedexService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class PokemonDetailViewModel (
    private val pokedexService: IPokedexService
): ViewModel(), LifecycleObserver {

    private val _pokemonResponse: MutableLiveData<PokemonDetail>? = MutableLiveData()
    val pokemonResponse: LiveData<PokemonDetail>? = _pokemonResponse

    fun getPokemon(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val pokemon = pokedexService.getPokemon(id)
                _pokemonResponse?.postValue(pokemon)
            } catch (t: Throwable) {

                withContext(Dispatchers.Main) {
                }
            }
        }
    }
}