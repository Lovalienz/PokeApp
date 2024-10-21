package com.poke.pokeapp.data.dataSource.remote.service

import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.GetAllCharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("/api/character/pokemon?limit=25")
    suspend fun getCharacters(@Query("offset") page: Int): Response<GetAllCharacterResponse>


    @GET("/api/character/pokemon/{id}/")
    suspend fun getCharacterInfo(@Path("id") idCharacter: Int): Response<CharacterModel>
}