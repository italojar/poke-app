package website.italojar.pokeapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.domain.usecase.GetPokemonsUseCase

class PokeListViewModel: ViewModel() {

    val getPokemonsUseCase = GetPokemonsUseCase()
    val pokemonsModel = MutableLiveData<List<Pokemon>>()

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            val pokemons = getPokemonsUseCase()
            if (!pokemons.isNullOrEmpty()){
                pokemonsModel.value = pokemons
            }
        }
    }

    fun updatePokemons(pokemons: MutableList<Pokemon>) {
        viewModelScope.launch { pokemonsModel.postValue(pokemons) }
    }
}