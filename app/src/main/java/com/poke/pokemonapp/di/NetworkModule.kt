package com.poke.pokemonapp.di

import com.poke.pokemonapp.core.Config
import com.poke.pokemonapp.data.dataSource.remote.service.PokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)

            .build()
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokeApiService =
        retrofit.create(PokeApiService::class.java)
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

}