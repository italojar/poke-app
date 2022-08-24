package website.italojar.pokeapi.presentation.interfaces

import website.italojar.pokeapi.databinding.ItemPokemonBinding
import website.italojar.pokeapi.domain.model.Pokemon
import java.text.FieldPosition

interface IPokemonListener {

    fun onPokemonClick(pokemon: Pokemon)
    fun onDeletePokemon(position: Int)
}