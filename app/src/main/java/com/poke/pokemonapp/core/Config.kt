package com.poke.pokemonapp.core

import com.poke.pokemonapp.domain.model.CharacterModel

object Config {
    const val BASE_URL: String = "https://pokeapi.co/api/v2/"
    var pokemonInfo: MutableList<CharacterModel> = mutableListOf()}