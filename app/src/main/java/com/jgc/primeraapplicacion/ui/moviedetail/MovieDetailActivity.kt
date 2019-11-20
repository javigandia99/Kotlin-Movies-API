package com.jgc.primeraapplicacion.ui.moviedetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.local.DatabaseFactory
import com.jgc.primeraapplicacion.data.local.RoomLocalRepository
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.model.DetailCast
import com.jgc.primeraapplicacion.model.DetailGenres
import com.jgc.primeraapplicacion.model.MovieDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {

    private lateinit var presenter: MovieDetailPresenter
    private lateinit var favButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setTitle(R.string.title_moviedetail)

        val movieId = intent.extras?.get("id")

        val localRepository = RoomLocalRepository(DatabaseFactory.getDatabase(this).favoritesDao())
        presenter = MovieDetailPresenter(this, localRepository)
        presenter.init(movieId as Int)

        favButton = findViewById(R.id.fav_button)
        favButton.setOnClickListener {
            presenter.setFavorite(movieId)

        }
    }

    override fun detail(detail: MovieDetail) {
        detail_movie_title.text = detail.title
        detail_year.text = detail.release_date
        detail_overview.text = detail.overview
        detail_score.text = detail.vote_average.toString()
        Picasso.get().load(RetrofitFactory.BASE_IMAGE_URL + detail.backdrop_path)
            .into(detail_movie_imageview)
    }

    @SuppressLint("SetTextI18n")
    override fun genres(genre: List<DetailGenres>) {
        if (genre.isNotEmpty()) {
            val genreCast = genre.joinToString(", ") { it.name }
            detail_genres_name.text = genreCast
        } else {
            detail_genres_name.text = getString(R.string.nogenres)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun cast(cast: List<DetailCast>) {
        if (cast.isNotEmpty()) {
            val forCast = cast.joinToString(", ", limit = 3) { it.name }
            detail_cast.text = forCast
        } else {
            detail_cast.text = getString(R.string.nocast)
        }
    }

    override fun crew(crew: List<DetailCast>) {
        val directorCrew = crew.filter { it.job == "Director" }.joinToString(", ") { it.name }
        detail_director.text = directorCrew
    }

    override fun checkFav(movieId: Int) {
        if (movieId != 0) {

            favButton.setImageResource(android.R.drawable.btn_star_big_on)

        } else {
            favButton.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }
}
