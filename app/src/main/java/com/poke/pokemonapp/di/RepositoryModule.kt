package com.poke.pokemonapp.di

import com.poke.pokemonapp.data.dataSource.remote.service.PokeApiService
import com.poke.pokemonapp.data.repositoryImpl.PokemonRepositoryImpl
import com.poke.pokemonapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providePokemonRepository(pokemonApi: PokeApiService): PokemonRepository =
        PokemonRepositoryImpl(pokemonApi)


}