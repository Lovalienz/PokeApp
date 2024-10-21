package com.poke.pokemonapp.data.dataSource.remote

import com.poke.pokeapp.data.dataSource.remote.service.PokeApiService
import com.poke.pokemonapp.domain.model.CharacterModel
import retrofit2.Response

class PokemonRemoteDataSourceImpl constructor(private val pokeApi: PokeApiService):
    PokemonRemoteDataSource {
    override suspend fun getAllCharacters(showPage: Int) = pokeApi.getCharacters(page = showPage)
    override suspend fun getCharacterInfo(idCharacter: String): Response<CharacterModel> {
        TODO("Not yet implemented")
    }
}