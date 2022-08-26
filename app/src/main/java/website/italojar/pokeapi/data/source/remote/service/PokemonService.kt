package website.italojar.pokeapi.data.source.remote.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import website.italojar.pokeapi.data.model.dto.PokemonData
import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.source.remote.interfaces.PokemonApiClient
import website.italojar.pokeapi.domain.repository.PokemonRepository
import website.italojar.pokeapi.common.RetrofitHelper

class PokemonService: PokemonRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getPokemons(): List<PokemonDto> {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonData> =
                retrofit.create(PokemonApiClient::class.java).getAllPokemons()
            response.body()?.results ?: emptyList()
        }
    }
}