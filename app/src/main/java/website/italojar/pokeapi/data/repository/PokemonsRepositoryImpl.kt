package website.italojar.pokeapi.data.repository

import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.source.remote.service.PokemonService
import website.italojar.pokeapi.data.source.local.PokeProvider
import website.italojar.pokeapi.data.source.remote.interfaces.PokemonApiClient
import website.italojar.pokeapi.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(
    private val service: PokemonService,
    private val pokemonProvider: PokeProvider
) : PokemonRepository {

    override suspend fun getPokemons(): List<PokemonDto> {
        val response:List<PokemonDto> = service.getPokemons()
        pokemonProvider.getPokemons = response
        return response
    }
}