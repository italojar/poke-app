package website.italojar.pokeapi.domain.usecase

import website.italojar.pokeapi.data.repository.PokemonsRepositoryImpl
import website.italojar.pokeapi.domain.mappers.toDomain
import website.italojar.pokeapi.domain.model.Pokemon

class GetPokemonsUseCase {

    private val repository = PokemonsRepositoryImpl()

    suspend operator fun invoke():List<Pokemon>{
        val pokemons = repository.getPokemons()

        return if(pokemons.isNotEmpty())
            pokemons.map { pokemonDto -> pokemonDto.toDomain() }
        else
            emptyList() // Call to Database
    }
}