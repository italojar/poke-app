package website.italojar.pokeapi.domain.usecase

import website.italojar.pokeapi.data.repository.PokemonsRepositoryImpl
import website.italojar.pokeapi.domain.mappers.toEntity
import website.italojar.pokeapi.domain.mappers.toPresentation
import website.italojar.pokeapi.presentation.model.PokemonVO
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonsRepositoryImpl
) {

    suspend operator fun invoke():List<PokemonVO>{
        val pokemons = repository.getPokemonsFromApi()

        return if(pokemons.isNotEmpty()) {
            repository.insertPokemons(pokemons.map { pokemon -> pokemon.toEntity() })
            repository.getPokemonsFromDatabase().map { pokemon -> pokemon.toPresentation()  }
        }else
            repository.getPokemonsFromDatabase().map { pokemon -> pokemon.toPresentation() }
    }
}