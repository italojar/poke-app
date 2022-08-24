package website.italojar.pokeapi.domain.mappers

import website.italojar.pokeapi.data.dto.PokemonDto
import website.italojar.pokeapi.domain.model.Pokemon

fun PokemonDto.toDomain() = Pokemon(
    name = this.name,
    url = this.url
)