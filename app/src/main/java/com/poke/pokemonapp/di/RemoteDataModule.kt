package com.poke.pokemonapp.di

import com.poke.pokemonapp.data.dataSource.remote.PokemonRemoteDataSource
import com.poke.pokemonapp.data.dataSource.remote.PokemonRemoteDataSourceImpl
import com.poke.pokeapp.data.dataSource.remote.service.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun providePokeApiRemoteDataSource(pokeApi: PokeApiService): PokemonRemoteDataSource =
        PokemonRemoteDataSourceImpl(pokeApi)
}