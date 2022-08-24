package website.italojar.pokeapi.domain.usecase

import website.italojar.pokeapi.data.service.PokemonService
import website.italojar.pokeapi.domain.mappers.toDomain
import website.italojar.pokeapi.domain.model.Pokemon

class GetPokemonsUseCase {

    val repository = PokemonService()

    suspend operator fun invoke():List<Pokemon>{
        val pokemons = repository.getPokemons()

        return if(pokemons.isNotEmpty()){
            pokemons.map { pokemonDto -> pokemonDto.toDomain() }
        }else{
            emptyList() // Call to Database
        }
    }
}