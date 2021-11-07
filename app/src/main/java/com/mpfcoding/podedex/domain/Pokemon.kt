package com.mpfcoding.podedex.domain

class Pokemon(
    val imageUrl: String? = null,
    val number: Int? = null,
    val name: String,
    val url: String,
    val types: List<PokemonType>? = null
){
    val formatterNumber = number.toString().padStart(3, '0')
}

