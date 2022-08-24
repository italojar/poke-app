package website.italojar.pokeapi.data.model.dto

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)