package website.italojar.pokeapi.presentation.pokemons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import website.italojar.pokeapi.databinding.FragmentPokeListBinding
import website.italojar.pokeapi.presentation.adapters.PokemonAdapter
import website.italojar.pokeapi.presentation.interfaces.IPokemonListener
import website.italojar.pokeapi.presentation.model.PokemonVO

@AndroidEntryPoint
class PokeListFragment : Fragment(), IPokemonListener {

    private var _binding: FragmentPokeListBinding? = null
    private val binding get() = _binding!!

    private val linearLayoutManager = LinearLayoutManager(context)
    private lateinit var pokemonsMutableList: MutableList<PokemonVO>
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
        pokemonsViewModel.pokemons.observe(viewLifecycleOwner, Observer { pokemons ->
            pokemonsMutableList = pokemons as MutableList<PokemonVO>
            initRecyclerView()
        })
        pokemonsViewModel.isLoading.observe(viewLifecycleOwner, Observer { visibility ->
            binding.progressBarApp.root.isVisible = visibility
        })
        binding.floatingActionButton.setOnClickListener { addPokemon() }
    }

    private fun initRecyclerView() {
        pokemonAdapter = PokemonAdapter(values = pokemonsMutableList, listeners = this)
        binding.rvPokemon.layoutManager = linearLayoutManager
        binding.rvPokemon.adapter = pokemonAdapter
    }

    private fun addPokemon() {
        if (!this::pokemonsMutableList.isInitialized){
            pokemonsMutableList = mutableListOf(
                PokemonVO("bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/1.png"))
            initRecyclerView()
        }else {
            val pokemon = PokemonVO("bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/1.png")
            pokemonsMutableList.add(0, pokemon)
            pokemonAdapter.notifyItemInserted(0)
            linearLayoutManager.scrollToPositionWithOffset(0, 8)
        }
        pokemonsViewModel.updatePokemons(pokemonsMutableList)
    }

    override fun onPokemonClick(pokemon: PokemonVO) {
        Toast.makeText(requireContext(), pokemon.name, Toast.LENGTH_SHORT).show()
    }

    override fun onDeletePokemon(position: Int) {
        pokemonsMutableList.removeAt(position)
        pokemonAdapter.notifyItemRemoved(position)
    }
}