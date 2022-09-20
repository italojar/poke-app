package website.italojar.pokeapi.domain.usecase

import website.italojar.pokeapi.data.repository.PokemonsRepositoryImpl
import website.italojar.pokeapi.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonsRepositoryImpl
) {

    suspend operator fun invoke():List<Pokemon>{

        val pokemons = repository.getPokemonsFromApi()

        return if(pokemons.isNotEmpty()) {
            repository.insertPokemons(pokemons)
            repository.getPokemonsFromDatabase()
        } else {
            repository.getPokemonsFromDatabase()
        }
    }
}