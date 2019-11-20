package com.jgc.primeraapplicacion.ui.moviedetail

import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.model.DetailCast
import com.jgc.primeraapplicacion.model.DetailGenres
import com.jgc.primeraapplicacion.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(private val view: MovieDetailView) {

    fun takeId(movieId: Int) {
        val movieApi = RetrofitFactory.getMovieApi()

        CoroutineScope(Dispatchers.IO).launch {
            val response = movieApi.getMoviesDetail(movieId, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseDetail = response.body()!!
                    view.detail(responseDetail)
                    val responseDetailGenres = response.body()!!.genres
                    view.genres(responseDetailGenres)
                }
            }

            val responseCast = movieApi.getMoviesCast(movieId, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (responseCast.isSuccessful) {
                    val responseDetailCast = responseCast.body()!!.cast
                    view.cast(responseDetailCast)
                    val responseDetailCrew = responseCast.body()!!.crew
                    view.crew(responseDetailCrew)
                }
            }
        }
    }

    fun addFavorites(){
        //TODO: implement insert
        view.showFavorites()
    }
}

interface MovieDetailView {
    fun detail(detail: MovieDetail)
    fun genres(genre: List<DetailGenres>)
    fun cast(cast: List<DetailCast>)
    fun crew(crew: List<DetailCast>)
    fun showFavorites()
}