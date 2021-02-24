package br.com.leonardo.pokedex.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

data class Pokemon (
    @SerializedName("name")
    var name: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("attack")
    var attack: Int? = null,
    @SerializedName("defense")
    var defense: Int? = null,
    @SerializedName("height")
    var height: String? = "",
    @SerializedName("hp")
    var hp: Int? = null,
    @SerializedName("pkdx_id")
    var id: Int? = null,
    @SerializedName("speed")
    var speed: Int? = null,
    @SerializedName("weight")
    var weight: String? = null
): Serializable {

    fun getNumber(pokemonUrl: String): Int {
        return pokemonUrl.substringAfter("pokemon/").substringBefore('/').toInt()
    }
}
