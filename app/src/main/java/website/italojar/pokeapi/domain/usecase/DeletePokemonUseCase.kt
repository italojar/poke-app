package website.italojar.pokeapi.domain.usecase

import website.italojar.pokeapi.data.repository.PokemonsRepositoryImpl
import website.italojar.pokeapi.domain.mappers.toEntity
import website.italojar.pokeapi.domain.model.Pokemon
import javax.inject.Inject

class DeletePokemonUseCase @Inject constructor(
    private val repository: PokemonsRepositoryImpl
) {

    suspend operator fun invoke(pokemon: Pokemon) {
        repository.deletePokemon(pokemon.toEntity())
    }

}