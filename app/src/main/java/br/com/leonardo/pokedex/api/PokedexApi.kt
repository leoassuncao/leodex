package br.com.leonardo.pokedex.api

import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail
import br.com.leonardo.pokedex.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

interface PokedexApi{

    companion object {
        private const val ALL_POKEMON_PATH = "pokemon?limit=964"
        private const val POKEMON_PATH = "pokemon/{id}"
    }

    @GET(ALL_POKEMON_PATH)
    suspend fun getAllPokemon(): Response

    @GET(POKEMON_PATH)
    suspend fun getPokemon(
        @Path("id") id: Int
    ): PokemonDetail?
}