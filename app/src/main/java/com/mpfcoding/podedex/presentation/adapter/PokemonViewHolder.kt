package com.mpfcoding.podedex.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mpfcoding.podedex.R
import com.mpfcoding.podedex.databinding.PokemonItemBinding
import com.mpfcoding.podedex.domain.Pokemon
import com.mpfcoding.podedex.utils.PokemonColorTypes
import com.mpfcoding.podedex.utils.PokemonTypesColor

class PokemonViewHolder(
    private val binding: PokemonItemBinding,
) : RecyclerView.ViewHolder(binding.root){

    @SuppressLint("SetTextI18n")
    fun bind(context: Context, item: Pokemon?) = with(itemView) {
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
            val typeName = item.types[0].name
            pokemonType1.text = typeName
            var color = PokemonColorTypes.getPokemonColorType(context, typeName)
            pokemonType1.setBackgroundColor(color)

            if (item.types.size > 1){
                val typeName2 = item.types[1].name
                color = PokemonColorTypes.getPokemonColorType(context, typeName2)
                pokemonType2.setBackgroundColor(color)
                pokemonType2.visibility = View.VISIBLE
                pokemonType2.text = item.types[1].name
            }else{
                pokemonType2.visibility = View.GONE
            }
        }
    }
}