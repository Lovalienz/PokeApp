package com.poke.pokemonapp.domain.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class Pokemon(
    val name: String,
    @SerializedName("url")val urlInfo: String
)
