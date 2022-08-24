package website.italojar.pokeapi.data.model.dto

data class PokemonData(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonDto>
)