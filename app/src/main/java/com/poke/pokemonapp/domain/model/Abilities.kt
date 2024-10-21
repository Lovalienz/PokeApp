package com.poke.pokemonapp.domain.model

import com.google.gson.annotations.SerializedName

data class Abilities(
    val ability: Ability
)

data class Ability(
    val name: String,
    @SerializedName("is_hidden") val isHidden: Boolean
)
