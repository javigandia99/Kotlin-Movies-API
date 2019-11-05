package com.jgc.primeraapplicacion.ui.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jgc.primeraapplicacion.R
import com.jgc.primeraapplicacion.data.RetrofitFactory
import com.jgc.primeraapplicacion.model.MovieDetail
import com.jgc.primeraapplicacion.model.MovieDetailCast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setTitle(R.string.title_moviedetail)

        val movieId = intent.extras?.get("id")
        val movieApi = RetrofitFactory.getMovieApi()

        CoroutineScope(Dispatchers.IO).launch {
            val response =
                movieApi.getMoviesDetail(movieId as Int, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responsedetail = response.body()!!
                    detail(responsedetail)
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val responsecast =
                movieApi.getMoviesCast(movieId as Int, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (responsecast.isSuccessful) {
                    val responsedetailcast = responsecast.body()!!
                    cast(responsedetailcast)
                }
            }
        }
    }

    private fun detail(detail: MovieDetail) {
        detail_movie_title.text = detail.title
        detail_year.text = detail.release_date
        detail_genres_name.text = detail.genres.toString()
        detail_overview.text = detail.overview
        Picasso.get().load(RetrofitFactory.BASE_URL+detail.backdrop_path).into(detail_movie_imageview)
    }

    private fun cast(cast: MovieDetailCast) {
        detail_cast.text = cast.name
        detail_director.text = cast.job

    }
}
