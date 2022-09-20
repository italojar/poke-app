package website.italojar.pokeapi.data.model.mappers

import website.italojar.pokeapi.data.model.entities.PokemonEntity
import website.italojar.pokeapi.domain.model.Pokemon

fun Pokemon.toEntity() = PokemonEntity(
    id = this.id,
    name = this.name,
    url = this.url
)