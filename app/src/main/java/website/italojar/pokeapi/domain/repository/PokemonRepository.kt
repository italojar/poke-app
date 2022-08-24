package website.italojar.pokeapi.domain.repository

import website.italojar.pokeapi.data.dto.PokemonDto

interface PokemonRepository {

    suspend fun getPokemons(): List<PokemonDto>
}