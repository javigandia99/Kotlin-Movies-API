package com.jgc.primeraapplicacion.ui.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.model.Movie

class MoviesAdapter(val movieList: List<Movie>) : RecyclerView.Adapter<MovieListViewHolder>() {

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movieItem = movieList[position]
        holder.bind(movieItem)
        holder.itemView.setOnClickListener {
        }
    }
}

class MovieListViewHolder private constructor(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(movieItem: Movie) {
    }

    //Fun static
    companion object {
        fun from(parent: ViewGroup): MovieListViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
            return MovieListViewHolder(view)
        }

    }
}
//TODO: Implement all of these fragment