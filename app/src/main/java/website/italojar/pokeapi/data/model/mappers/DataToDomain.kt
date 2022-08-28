package website.italojar.pokeapi.data.model.mappers

import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.model.entities.PokemonEntity
import website.italojar.pokeapi.domain.model.Pokemon

fun PokemonDto.toDomain() = Pokemon(
    id = 0,
    name = this.name,
    url = this.url
)

fun PokemonEntity.toDomain() = Pokemon(
    id = this.id,
    name = this.name,
    url = this.url
)