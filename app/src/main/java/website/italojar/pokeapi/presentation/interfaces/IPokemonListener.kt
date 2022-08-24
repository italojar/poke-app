package website.italojar.pokeapi.presentation.interfaces

import website.italojar.pokeapi.databinding.ItemPokemonBinding
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.presentation.model.PokemonVO
import java.text.FieldPosition

interface IPokemonListener {

    fun onPokemonClick(pokemon: PokemonVO)
    fun onDeletePokemon(position: Int)
}