package com.poke.pokemonapp.ui.screens.characters

import androidx.lifecycle.ViewModel

import androidx.paging.PagingData
import com.poke.pokemonapp.domain.model.CharacterModel
import com.poke.pokemonapp.domain.model.Pokemon
import com.poke.pokemonapp.domain.repository.PokemonRepository
import com.poke.pokemonapp.domain.useCase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
): ViewModel() {
    val characters: Flow<PagingData<Pokemon>> = pokemonUseCase.getAllCharacter()


}