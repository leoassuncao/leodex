package br.com.leonardo.pokedex.service

import br.com.leonardo.pokedex.api.PokedexApi
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail
import com.google.gson.Gson

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class PokedexService(
    internal  val pokedexApi: PokedexApi
) : IPokedexService{

    override suspend fun getAllPokemon(): List<Pokemon>? {
        val response = pokedexApi.getAllPokemon()
        return response.pokemon
    }

    override suspend fun getPokemon(id: Int): PokemonDetail? {
        return pokedexApi.getPokemon(id)
    }
}