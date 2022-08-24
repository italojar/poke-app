package website.italojar.pokeapi.data.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import website.italojar.pokeapi.data.source.local.PokeProvider
import website.italojar.pokeapi.data.dto.PokemonDto
import website.italojar.pokeapi.domain.repository.PokemonRepository

class PokemonService: PokemonRepository {

    private val api = PokeProvider()

    override suspend fun getPokemons(): List<PokemonDto> {
        return  withContext(Dispatchers.IO) {
            val response = api.getPokemons()
            response ?: emptyList()
            //response.body() ?: emptyList()
        }
    }

}