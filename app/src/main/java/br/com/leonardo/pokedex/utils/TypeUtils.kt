package br.com.leonardo.pokedex.utils

import br.com.leonardo.pokedex.R

/**
 * @author Leonardo Assunção
 * @since 23/02/21
 **/

object TypeUtils {

    fun getTypeColor(type: String): Int {
        return when (type) {
            "normal" -> R.color.normal
            "fire" -> R.color.fire
            "water" -> R.color.water
            "electric" -> R.color.electric
            "grass" -> R.color.grass
            "ice" -> R.color.ice
            "fight" -> R.color.fight
            "poison" -> R.color.poison
            "ground" -> R.color.ground
            "flying" -> R.color.flying
            "psychic" -> R.color.psychic
            "bug" -> R.color.bug
            "rock" -> R.color.rock
            "ghost" -> R.color.ghost
            "dragon" -> R.color.dragon
            "dark" -> R.color.dark
            "steel" -> R.color.steel
            "fairy" -> R.color.fairy
            else -> R.color.normal
        }
    }
}
