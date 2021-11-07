package com.mpfcoding.podedex.presentation.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mpfcoding.podedex.databinding.PokemonItemBinding
import com.mpfcoding.podedex.domain.Pokemon

class PokemonViewHolder(
    private val binding: PokemonItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: Pokemon?) = with(itemView) {
        val imagePokemon = binding.imagePokemon
        val pokemonNumber = binding.textPokemonNumber
        val pokemonName = binding.textPokemonName
        val pokemonType1 = binding.textType1
        val pokemonType2 = binding.textType2

        item?.let {
            Glide.with(itemView.context)
                .load(it.imageUrl)
                .into(imagePokemon)

            pokemonNumber.text = "Nº ${item.formatterNumber}"
            pokemonName.text = item.formatterName
            pokemonType1.text = item.types[0].name

            if (item.types.size > 1){
                pokemonType2.visibility = View.VISIBLE
                pokemonType2.text = item.types[1].name
            }else{
                pokemonType2.visibility = View.GONE
            }
        }
    }
}