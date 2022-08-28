package website.italojar.pokeapi.data.source.remote.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import website.italojar.pokeapi.data.model.dto.PokemonData
import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.source.remote.interfaces.PokemonApiClient
import website.italojar.pokeapi.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonService @Inject constructor(
    private val apiClient: PokemonApiClient
) {

    suspend fun getPokemonsFromApi(): List<PokemonDto> {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonData> = apiClient.getAllPokemons()
            response.body()?.results ?: emptyList()
        }
    }
}