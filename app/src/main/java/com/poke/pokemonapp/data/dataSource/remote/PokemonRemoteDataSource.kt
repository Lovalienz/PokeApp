package com.poke.pokemonapp.data.dataSource.remote

import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.GetAllCharacterResponse
import retrofit2.Response

interface PokemonRemoteDataSource {

    suspend fun getAllCharacters(showPage: Int): Response<GetAllCharacterResponse>
    suspend fun getCharacterInfo(idCharacter: String): Response<CharacterModel>

}