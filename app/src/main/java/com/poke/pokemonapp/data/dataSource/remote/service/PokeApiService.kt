package com.poke.pokemonapp.data.dataSource.remote.service

import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.GetAllCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {


    @GET("pokemon")
    suspend fun getCharacters(@Query("offset") page: Int): GetAllCharacterResponse


    @GET("{url}")
    suspend fun getCharacterInfo(@Path("url") urlCharacter: String): CharacterModel

}