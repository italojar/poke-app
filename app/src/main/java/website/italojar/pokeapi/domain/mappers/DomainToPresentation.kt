package website.italojar.pokeapi.domain.mappers

import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.presentation.model.PokemonVO

fun Pokemon.toPresentation() = PokemonVO(
    name = this.name,
    url = this.url
)