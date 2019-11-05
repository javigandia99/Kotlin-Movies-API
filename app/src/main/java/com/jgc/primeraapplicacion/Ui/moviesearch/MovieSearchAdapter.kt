package com.jgc.primeraapplicacion.ui.moviesearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.model.Movie
import com.squareup.picasso.Picasso

class MovieSearchAdapter(private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>() {
    private var movies = listOf<Movie>()

    fun addMovies(newMovie: List<Movie>) {
        this.movies = newMovie
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position], listener)
    }

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.item_title)
        private val image = view.findViewById<ImageView>(R.id.item_image)
        private val overview = view.findViewById<TextView>(R.id.item_overview)
        private val score = view.findViewById<TextView>(R.id.item_score)
        private val year = view.findViewById<TextView>(R.id.item_year)

        fun bind(movie: Movie, listener: (Movie) -> Unit) {
            title.text = movie.title
            Picasso.get().load(movie.poster_path).into(image)
            overview.text = movie.overview
            year.text = movie.release_date
            score.text = movie.vote_average.toString()

            this.itemView.setOnClickListener { listener.invoke(movie) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
                return ViewHolder(view)
            }
        }
    }
}