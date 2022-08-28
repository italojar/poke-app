package website.italojar.pokeapi.domain.mappers

import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.presentation.model.PokemonVO

fun Pokemon.toPresentation() = PokemonVO(
    id = this.id,
    name = this.name,
    url = this.url
)