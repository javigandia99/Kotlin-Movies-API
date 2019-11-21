package com.jgc.primeraapplicacion.ui.favoriteslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.FavoritesEntity
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.squareup.picasso.Picasso

class FavoritesAdapter(private val listener: (FavoritesEntity) -> Unit) :
    RecyclerView.Adapter<FavoritesViewHolder>() {
    private var favorites = listOf<FavoritesEntity>()

    fun addFavorites(listFavorites: List<FavoritesEntity>) {
        this.favorites = listFavorites
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder.from(parent)
    }

    override fun getItemCount(): Int = favorites.size

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(favorites[position], listener)
    }
}

class FavoritesViewHolder private constructor(val view: View) : RecyclerView.ViewHolder(view) {
    private val title = view.findViewById<TextView>(R.id.item_title)
    private val image = view.findViewById<ImageView>(R.id.item_image)
    private val adult = view.findViewById<TextView>(R.id.item_adult)
    private val popularity = view.findViewById<TextView>(R.id.item_popularity)
    private val score = view.findViewById<TextView>(R.id.item_score)
    private val year = view.findViewById<TextView>(R.id.item_year)

    @SuppressLint("SetTextI18n")
    fun bind(entities: FavoritesEntity, listener: (FavoritesEntity) -> Unit) {
        title.text = entities.title
        Picasso.get().load(RetrofitFactory.BASE_IMAGE_URL + entities.poster_path).into(image)
        adult.text = entities.adult.toString()
        if (adult.text == "true") {
            adult.text = "Only Adults"
        }
        if (adult.text == "false") {
            adult.text = "No"
        }
        if (adult.text == "null") {
            adult.text = "No classified"
        }

        popularity.text = entities.popularity.toString()
        year.text = entities.release_date
        score.text = entities.vote_average.toString()
        this.itemView.setOnClickListener { listener.invoke(entities) }
    }

    //Fun static
    companion object {
        fun from(parent: ViewGroup): FavoritesViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
            return FavoritesViewHolder(view)
        }
    }
}
