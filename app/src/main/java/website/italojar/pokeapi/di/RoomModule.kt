package website.italojar.pokeapi.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import website.italojar.pokeapi.data.database.PokemonDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val POKEMON_DATABASE_NAME = "pokemon_database"

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PokemonDatabase::class.java, POKEMON_DATABASE_NAME).build()

    @Provides
    @Singleton
    fun providePokemonDao(database: PokemonDatabase) = database.getPokemons()
}