package website.italojar.pokeapi.data.database

import androidx.room.*
import website.italojar.pokeapi.data.model.entities.PokemonEntity

@Dao
interface PokemonDao {

    @Query("select * from pokemon_table order by id desc")
    suspend fun getAllPokemons(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemons(pokemons: List<PokemonEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Delete
    suspend fun deletePokemon(pokemon: PokemonEntity)

    @Query("delete from pokemon_table")
    suspend fun deleteAll()
}