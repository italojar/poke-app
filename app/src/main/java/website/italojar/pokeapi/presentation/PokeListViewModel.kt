package website.italojar.pokeapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import website.italojar.pokeapi.domain.mappers.toPresentation
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.domain.usecase.GetPokemonsUseCase
import website.italojar.pokeapi.presentation.model.PokemonVO

class PokeListViewModel: ViewModel() {

    val getPokemonsUseCase = GetPokemonsUseCase()
    val pokemonsModel = MutableLiveData<List<PokemonVO>>()

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            val pokemons = getPokemonsUseCase()
            if (!pokemons.isNullOrEmpty()){
                pokemonsModel.value = pokemons.map { pokemon -> pokemon.toPresentation() }
            }
        }
    }

    fun updatePokemons(pokemons: MutableList<PokemonVO>) {
        viewModelScope.launch { pokemonsModel.postValue(pokemons) }
    }
}