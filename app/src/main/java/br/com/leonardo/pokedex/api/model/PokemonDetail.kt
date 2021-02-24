package br.com.leonardo.pokedex.api.model

import br.com.leonardo.pokedex.api.model.SpriteDto
import br.com.leonardo.pokedex.api.model.TypeDto
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.sql.Types

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

data class PokemonDetail(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("types")
    var types: List<Types>,
    @SerializedName("base_experience")
    var experience: Int = 0,
    @SerializedName("weight")
    var weight: Int = 0,
    @SerializedName("stats")
    var stats: List<Stats>)

{
    data class Types(
        @SerializedName("slot")
        var slot: Int = 0,
        @SerializedName("type")
        var type: Type
    )

    data class Type(
        @SerializedName("name")
        var typeName: String = ""
    )

    data class Stats(
        @SerializedName("base_stat")
        var baseStat: Int = 0,
        @SerializedName("stat")
        var stat: Stat
    )

    data class Stat(
        @SerializedName("name")
        var statName: String = ""
    )
}