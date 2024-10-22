package com.poke.pokemonapp.data.repositoryImpl

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poke.pokemonapp.data.dataSource.remote.PokemonRemoteDataSourceImpl
import com.poke.pokemonapp.data.dataSource.remote.service.PokeApiService
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.Pokemon
import com.poke.pokemonapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImpl(private val pokeApi: PokeApiService): PokemonRepository {
    companion object{
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 5
    }
    override fun getAlCharacters(): Flow<PagingData<Pokemon>> {

        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                Log.w("EjecuionPanel", "impl del repo eje")

                PokemonRemoteDataSourceImpl(pokeApi)
            }).flow
    }
}