package website.italojar.pokeapi.data.source.local

import website.italojar.pokeapi.data.dto.PokemonDto

class PokeProvider {

    fun getPokemons() = listOf<PokemonDto>(
        PokemonDto("Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/1.png"),
        PokemonDto("Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/6.png"),
        PokemonDto("Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/25.png"),
    )
}