package com.poke.pokeapp.domain.useCase

import com.poke.pokemonapp.domain.repository.PokemonRepository

class GetAllCharactersUseCase constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke() = repository.getAlCharacters()
}