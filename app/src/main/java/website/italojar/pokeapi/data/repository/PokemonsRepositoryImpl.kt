package website.italojar.pokeapi.data.repository

import website.italojar.pokeapi.data.database.PokemonDao
import website.italojar.pokeapi.data.model.dto.PokemonDto
import website.italojar.pokeapi.data.model.entities.PokemonEntity
import website.italojar.pokeapi.data.model.mappers.toDomain
import website.italojar.pokeapi.data.source.remote.service.PokemonService
import website.italojar.pokeapi.data.model.mappers.toEntity
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonsRepositoryImpl @Inject constructor(
    private val service: PokemonService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override suspend fun getPokemonsFromApi(): List<Pokemon> {
        val response:List<PokemonDto> = service.getPokemonsFromApi()
        return response.map { pokemonDto -> pokemonDto.toDomain()  }
    }

    override suspend fun getPokemonsFromDatabase(): List<Pokemon> {
        val response: List<PokemonEntity> = pokemonDao.getAllPokemons()
        return response.map { pokemonEntity -> pokemonEntity.toDomain() }
    }

    override suspend fun insertPokemons(pokemons: List<Pokemon>) {
        pokemonDao.insertAllPokemons(pokemons.map { pokemon -> pokemon.toEntity() })
    }

    override suspend fun insertPokemon(pokemon: Pokemon) {
        pokemonDao.insertPokemon(pokemon.toEntity())
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        pokemonDao.deletePokemon(pokemon.toEntity())
    }

    override suspend fun clearPokemons() {
        pokemonDao.deleteAll()
    }
}