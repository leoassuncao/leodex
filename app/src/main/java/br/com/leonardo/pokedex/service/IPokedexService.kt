package br.com.leonardo.pokedex.service

import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

interface IPokedexService {
    suspend fun getAllPokemon(): List<Pokemon>?
    suspend fun getPokemon(id: Int): PokemonDetail?
}