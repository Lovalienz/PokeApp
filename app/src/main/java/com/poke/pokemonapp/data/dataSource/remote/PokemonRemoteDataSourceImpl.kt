package com.poke.pokemonapp.data.dataSource.remote

import android.util.Log
import androidx.paging.Config
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.poke.pokemonapp.data.dataSource.remote.service.PokeApiService
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.Pokemon

import java.io.IOException
import javax.inject.Inject

 class PokemonRemoteDataSourceImpl @Inject constructor(private val pokeApi: PokeApiService):
    PagingSource<Int, Pokemon>(){



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {

        val page = params.key ?: 1
        val response = pokeApi.getCharacters(page)

        val characters = response.pokemonResults




        val prevKey = if (page > 1) page - 1 else null
        val nextKey = if (response.nextPage != null) page + 1 else null

        val myList: MutableList<Pokemon> = mutableListOf()

        characters.forEach { character ->
            try {
                if (character.urlInfo != null) {
                    myList.add(character)
                    Log.w("EjecuionPanel", "${character.urlInfo}")

                    val finalUrl = character.urlInfo.substringAfter("v2/")
                    com.poke.pokemonapp.core.Config.pokemonInfo.add(pokeApi.getCharacterInfo(finalUrl))

                    Log.w("EjecuionPanel", "${character.urlInfo}")

                }
            } catch (e: Exception) {
                Log.w("EjecuionPanel", "$e")
            }
        }

        return LoadResult.Page(
            data = myList,
            prevKey = prevKey,
            nextKey = nextKey
        )

    } catch (exception: IOException) {
        return LoadResult.Error(exception)
    }
    }

     override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
         return state.anchorPosition
     }


 }