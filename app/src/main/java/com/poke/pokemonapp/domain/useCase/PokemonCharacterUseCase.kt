package com.poke.pokemonapp.domain.useCase

import com.poke.pokeapp.domain.useCase.GetAllCharactersUseCase

data class PokemonUseCase(
    val getAllCharacter: GetAllCharactersUseCase,
)
