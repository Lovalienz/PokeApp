package com.poke.pokemonapp.domain.repository

import androidx.paging.PagingData
import com.poke.pokemonapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun getAlCharacters(): Flow<PagingData<CharacterModel>>

}