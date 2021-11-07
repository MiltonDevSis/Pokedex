package com.mpfcoding.podedex.api.model

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonApiResultDescription>
)