package br.com.leonardo.pokedex.model

import br.com.leonardo.pokedex.KoinComponentTest
import br.com.leonardo.pokedex.api.model.Pokemon
import org.junit.Test

import org.junit.Assert.*

import org.koin.core.inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PokemonTest : KoinComponentTest() {

    private val pokemon: Pokemon by inject()

    @Test
    fun `getNumber returns true if has number`() {

        //given
        pokemon.apply {
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        }

        //when
        val result = pokemon.getNumber(pokemonUrl = pokemon.url)

        //then
        assertEquals(1, result)
    }
}