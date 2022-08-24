package website.italojar.pokeapi.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import website.italojar.pokeapi.R
import website.italojar.pokeapi.databinding.ItemPokemonBinding
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.presentation.interfaces.IPokemonListener
import com.squareup.picasso.Picasso
import website.italojar.pokeapi.presentation.model.PokemonVO


class PokemonAdapter(
    private val values: List<PokemonVO>,
    private val listeners: IPokemonListener
): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.render(values[position])
    }

    override fun getItemCount() = values.size

    inner class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemPokemonBinding.bind(view)

        fun render(pokemon: PokemonVO) {
            binding.pokemonName.text = pokemon.name
            Picasso.get().load(pokemon.url)
                .resize(360, 360)
                .centerCrop().into(binding.pokemonImage)

            binding.pokemonContainer.setOnClickListener { listeners.onPokemonClick(pokemon) }
            binding.btnDelete.setOnClickListener { listeners.onDeletePokemon(adapterPosition) }
        }
    }
}