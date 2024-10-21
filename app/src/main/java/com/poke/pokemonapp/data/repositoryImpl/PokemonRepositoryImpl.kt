package com.poke.pokemonapp.data.repositoryImpl

import androidx.paging.PagingData
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImpl: PokemonRepository {
    override suspend fun getAlCharacters(): Flow<PagingData<CharacterModel>> {
        TODO("Not yet implemented")
    }
}