package website.italojar.pokeapi.data.repository

import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.source.remote.service.PokemonService
import website.italojar.pokeapi.data.source.local.PokeProvider
import website.italojar.pokeapi.domain.repository.PokemonRepository

class PokemonsRepositoryImpl: PokemonRepository {

    private val api = PokemonService()

    override suspend fun getPokemons(): List<PokemonDto> {
        val response:List<PokemonDto> = api.getPokemons()
        PokeProvider().getPokemons = response
        return response
    }
}