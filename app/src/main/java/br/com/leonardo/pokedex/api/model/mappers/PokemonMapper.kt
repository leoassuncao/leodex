package br.com.leonardo.pokedex.api.model.mappers

import br.com.leonardo.pokedex.api.model.Pokemon

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

fun Pokemon.toBusinessModel(): Pokemon {
    return Pokemon(
        name = name,
        attack = attack,
        defense = defense,
        height = height,
        hp = hp,
        id = id,
        speed = speed,
         weight = weight
    )
}

fun List<Pokemon>.toBusinessModeList(): List<Pokemon> {
    return map {
        it.toBusinessModel()
    }
}