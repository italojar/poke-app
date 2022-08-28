package website.italojar.pokeapi.data.source.local

import website.italojar.pokeapi.data.model.dto.PokemonDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeProvider @Inject constructor() {

    var getPokemons = emptyList<PokemonDto>()
}