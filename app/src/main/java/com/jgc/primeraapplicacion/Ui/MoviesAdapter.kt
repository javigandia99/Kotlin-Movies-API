package com.jgc.primeraapplicacion.Ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.Model.Movie
import com.jgc.primeraapplicacion.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

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
    }


}

class MovieListViewHolder private constructor(val view: View) : RecyclerView.ViewHolder(view) {


    fun bind(movieItem: Movie) {
        view.item_tittle.text = movieItem.tittle
        Picasso.get().load(movieItem.imageMovie).into(view.item_image)
        view.item_genre.text = movieItem.genreMovie
        view.item_year.text = movieItem.release_date
        view.item_score.text = movieItem.score.toString()
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