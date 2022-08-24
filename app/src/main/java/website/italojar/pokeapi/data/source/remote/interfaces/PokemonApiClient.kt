package website.italojar.pokeapi.data.source.remote.interfaces

import retrofit2.Response
import retrofit2.http.GET
import website.italojar.pokeapi.data.model.dto.PokemonData

interface PokemonApiClient {

    @GET("pokemon?limit=10&offset=0")
    suspend fun getAllPokemons(): Response<PokemonData>
}