package com.poke.pokemonapp.domain.repository

import androidx.paging.PagingData
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

   fun getAlCharacters(): Flow<PagingData<Pokemon>>

}