package website.italojar.pokeapi.presentation.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import website.italojar.pokeapi.domain.mappers.toPresentation
import website.italojar.pokeapi.domain.usecase.GetPokemonsUseCase
import website.italojar.pokeapi.presentation.model.PokemonVO
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
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
                _pokemons.value = pokemonsList.map { pokemon -> pokemon.toPresentation() }
                isLoading.postValue(false)
            }
        }
    }

    fun updatePokemons(pokemons: MutableList<PokemonVO>) {
        viewModelScope.launch { _pokemons.postValue(pokemons) }
    }
}