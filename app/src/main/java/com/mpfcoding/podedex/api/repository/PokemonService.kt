package com.mpfcoding.podedex.api.repository

import com.mpfcoding.podedex.api.model.PokemonsApiResult
import com.mpfcoding.podedex.api.model.SinglePokemonApiResultDescription
import com.mpfcoding.podedex.api.service.PokemonService
import com.mpfcoding.podedex.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonService {

    private val service: PokemonService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.POKEMON_API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 30): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemons(number: Int): SinglePokemonApiResultDescription? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }
}