package website.italojar.pokeapi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import website.italojar.pokeapi.data.model.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemons(): PokemonDao
}