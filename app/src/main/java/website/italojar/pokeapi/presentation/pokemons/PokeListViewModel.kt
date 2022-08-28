package website.italojar.pokeapi.presentation.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import website.italojar.pokeapi.domain.mappers.toPresentation
import website.italojar.pokeapi.domain.usecase.DeletePokemonUseCase
import website.italojar.pokeapi.domain.usecase.GetPokemonsUseCase
import website.italojar.pokeapi.domain.usecase.InsertPokemonUseCase
import website.italojar.pokeapi.presentation.model.PokemonVO
import website.italojar.pokeapi.presentation.model.mappers.toDomain
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val insertPokemonUseCase: InsertPokemonUseCase,
    private val deletePokemonUseCase: DeletePokemonUseCase
) : ViewModel() {

    private val _pokemons = MutableLiveData<List<PokemonVO>>()
    val pokemons: LiveData<List<PokemonVO>> = _pokemons
    val isLoading = MutableLiveData<Boolean>()

    init {
        getPokemons()
    }

    private fun getPokemons() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val pokemonsList = getPokemonsUseCase()
            if (!pokemonsList.isNullOrEmpty()){
                _pokemons.value = pokemonsList
                isLoading.postValue(false)
            }
        }
    }

    fun updatePokemon(pokemon: PokemonVO) {
        viewModelScope.launch {
            insertPokemonUseCase.invoke(pokemon.toDomain())
        }
    }

    fun deletePokemon(pokemon: PokemonVO) {
        viewModelScope.launch {
            deletePokemonUseCase.invoke(pokemon.toDomain())
        }
    }
}