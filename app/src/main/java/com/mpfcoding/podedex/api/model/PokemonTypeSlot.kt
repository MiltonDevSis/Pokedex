package com.mpfcoding.podedex.api.model

import com.mpfcoding.podedex.domain.PokemonType

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
