package br.com.leonardo.pokedex.api.model

import com.google.gson.annotations.SerializedName

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

data class TypeDto (
    @SerializedName("name")
    var name: String = ""
)