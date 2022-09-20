package website.italojar.pokeapi.domain.repository

import website.italojar.pokeapi.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonsFromApi(): List<Pokemon>
    suspend fun getPokemonsFromDatabase(): List<Pokemon>
    suspend fun insertPokemons(pokemons: List<Pokemon>)
    suspend fun insertPokemon(pokemon: Pokemon)
    suspend fun deletePokemon(pokemon: Pokemon)
    suspend fun clearPokemons()
}