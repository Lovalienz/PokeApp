package com.poke.pokeapp.domain.useCase

import com.poke.pokemonapp.domain.repository.PokemonRepository

class GetAllCharactersUseCase constructor(private val repository: PokemonRepository) {

    operator fun invoke() = repository.getAlCharacters()
}