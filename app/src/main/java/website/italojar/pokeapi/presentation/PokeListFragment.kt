package website.italojar.pokeapi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import website.italojar.pokeapi.databinding.FragmentPokeListBinding
import website.italojar.pokeapi.domain.model.Pokemon
import website.italojar.pokeapi.presentation.adapters.PokemonAdapter
import website.italojar.pokeapi.presentation.interfaces.IPokemonListener


class PokeListFragment : Fragment(), IPokemonListener {

    private var _binding: FragmentPokeListBinding? = null
    private val binding get() = _binding!!

    private val linearLayoutManager = LinearLayoutManager(context)
    private lateinit var pokemonsMutableList: MutableList<Pokemon>
    private val pokemonsViewModel: PokeListViewModel by viewModels()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentPokeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonsViewModel.pokemonsModel.observe(viewLifecycleOwner, Observer { pokemons ->
            pokemonsMutableList = pokemons as MutableList<Pokemon>
            initRecyclerView()
        })
        binding.floatingActionButton.setOnClickListener { addPokemon() }
    }

    private fun initRecyclerView() {
        pokemonAdapter = PokemonAdapter(values = pokemonsMutableList, listeners = this)
        binding.rvPokemon.layoutManager = linearLayoutManager
        binding.rvPokemon.adapter = pokemonAdapter
    }

    override fun onPokemonClick(pokemon: Pokemon) {
        Toast.makeText(requireContext(), pokemon.name, Toast.LENGTH_SHORT).show()
    }

    override fun onDeletePokemon(position: Int) {
        pokemonsMutableList.removeAt(position)
        pokemonAdapter.notifyItemRemoved(position)
    }

    private fun addPokemon() {
        if (!this::pokemonsMutableList.isInitialized){
            pokemonsMutableList = mutableListOf(
                Pokemon("bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/1.png"))
            initRecyclerView()
        }else {
            val pokemon = Pokemon("bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/1.png")
            pokemonsMutableList.add(0, pokemon)
            pokemonAdapter.notifyItemInserted(0)
            linearLayoutManager.scrollToPositionWithOffset(0, 8)
        }
        pokemonsViewModel.updatePokemons(pokemonsMutableList)
    }
}