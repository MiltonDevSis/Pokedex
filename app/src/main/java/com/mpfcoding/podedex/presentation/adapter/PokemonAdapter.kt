package com.mpfcoding.podedex.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mpfcoding.podedex.databinding.PokemonItemBinding
import com.mpfcoding.podedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon?>,
    private val context: Context
) : RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = items[position]

        holder.bind(context, item)
    }

    override fun getItemCount() = items.size
}