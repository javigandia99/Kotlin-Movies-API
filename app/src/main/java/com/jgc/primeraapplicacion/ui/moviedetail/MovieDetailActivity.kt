package com.jgc.primeraapplicacion.ui.moviedetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.model.DetailCast
import com.jgc.primeraapplicacion.model.DetailGenres
import com.jgc.primeraapplicacion.model.MovieDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity(), MovieDetailView {

    private val presenter = MovieDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setTitle(R.string.title_moviedetail)

        val movieId = intent.extras?.get("id")
        presenter.takeId(movieId as Int)
    }

    override fun detail(detail: MovieDetail) {
        detail_movie_title.text = detail.title
        detail_year.text = detail.release_date
        detail_overview.text = detail.overview
        Picasso.get().load(RetrofitFactory.BASE_IMAGE_URL + detail.backdrop_path)
            .into(detail_movie_imageview)
    }

    @SuppressLint("SetTextI18n")
    override fun genres(genre: List<DetailGenres>) {
        val firstCast = genre[0]
        val secondCast = genre[1]
        detail_genres_name.text = firstCast.name + ", " + secondCast.name
    }

    @SuppressLint("SetTextI18n")
    override fun cast(cast: List<DetailCast>) {
        val firstCast = cast[0]
        val secondCast = cast[1]
        val thirdCast = cast[2]
        detail_cast.text = firstCast.name + ", " + secondCast.name + ", " + thirdCast.name
    }

    override fun crew(crew: List<DetailCast>) {
        val firstcrew = crew[0]
        //TODO:Implement crew to Api
        detail_director.text = firstcrew.job
    }
}
