package com.poke.pokemonapp.domain.model

import com.google.gson.annotations.SerializedName

data class GetAllCharacterResponse(
    @SerializedName("count") val currentPage: Int?,
    @SerializedName("next") val nextPage: String?,
    @SerializedName("previous") val previousPage: String?,
    @SerializedName("results") val pokemonResults: List<Pokemon>
)
