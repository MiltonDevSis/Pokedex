package com.mpfcoding.podedex.api.model

import com.mpfcoding.podedex.domain.Pokemon

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)