package com.jgc.primeraapplicacion.ui.favoriteslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.model.Movie

class FavoritesAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<FavoritesViewHolder>() {

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val movieItem = movieList[position]
        holder.bind(movieItem)
        holder.itemView.setOnClickListener {
        }
    }
}

class  FavoritesViewHolder private constructor(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(favoritesItem: Movie) {
    }

    //Fun static
    companion object {
        fun from(parent: ViewGroup): FavoritesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
            return FavoritesViewHolder(view)
        }

    }
}
//TODO: Implement all of these fragment