package website.italojar.pokeapi.domain.repository

import website.italojar.pokeapi.data.model.entities.PokemonEntity
import website.italojar.pokeapi.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonsFromApi(): List<Pokemon>
    suspend fun getPokemonsFromDatabase(): List<Pokemon>
    suspend fun insertPokemons(pokemons: List<PokemonEntity>)
    suspend fun insertPokemon(pokemon: PokemonEntity)
    suspend fun deletePokemon(pokemon: PokemonEntity)
    suspend fun clearPokemons()
}