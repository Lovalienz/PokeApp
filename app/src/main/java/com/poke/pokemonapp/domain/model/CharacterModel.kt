package com.poke.pokemonapp.domain.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<Abilities>,
    val sprites: FrontDefault,
    var isFavorite: Boolean = false
)
