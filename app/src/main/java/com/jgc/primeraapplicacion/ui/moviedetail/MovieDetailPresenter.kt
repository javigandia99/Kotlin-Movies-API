package com.jgc.primeraapplicacion.ui.moviedetail

import com.jgc.primeraapplicacion.data.local.FavoritesEntity
import com.jgc.primeraapplicacion.data.local.LocalRepository
import com.jgc.primeraapplicacion.data.remote.RemoteRepository
import com.jgc.primeraapplicacion.model.DetailCast
import com.jgc.primeraapplicacion.model.DetailGenres
import com.jgc.primeraapplicacion.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(private val view: MovieDetailView, private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {

    fun init(movieId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                remoteRepository.getMoviesDetail(movieId, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseDetail = response.body()!!
                    view.showDetail(responseDetail)
                    val responseDetailGenres = response.body()!!.genres
                    view.showGenres(responseDetailGenres)
                }
            }

            val responseCast =
                remoteRepository.getMoviesCast(movieId, "6d247d2725f2627d9e371751ce4e8679")
            withContext(Dispatchers.Main) {
                if (responseCast.isSuccessful) {
                    val responseDetailCast = responseCast.body()!!.cast
                    view.showCast(responseDetailCast)
                    val responseDetailCrew = responseCast.body()!!.crew
                    view.showCrew(responseDetailCrew)
                }
            }
        }
    }

    fun setFavorite(movieId: Int) {
        var responseDatabase: Int?
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                remoteRepository.getMoviesDetail(movieId, "6d247d2725f2627d9e371751ce4e8679")
            if (response.isSuccessful) {
                val id = response.body()!!.id
                val image = response.body()!!.poster_path
                val title = response.body()!!.title
                val date = response.body()!!.release_date
                val adult = response.body()!!.adult
                val popularity = response.body()!!.popularity
                val average = response.body()!!.vote_average
                val currentTimestamp = System.currentTimeMillis().toString()

                val entity = FavoritesEntity(id, image, title, date, adult, popularity, average, currentTimestamp)

                responseDatabase = localRepository.checkFavorite(id)
                if (responseDatabase == null) {
                    localRepository.insertFavorite(entity)
                    withContext(Dispatchers.Main) {
                        view.checkFav(responseDatabase)
                    }
                } else {
                    localRepository.deleteFavorite(entity)
                    withContext(Dispatchers.Main) {
                        view.checkFav(responseDatabase)
                    }
                }
            }
        }
    }
}

interface MovieDetailView {
    fun showDetail(detail: MovieDetail)
    fun showGenres(genre: List<DetailGenres>)
    fun showCast(cast: List<DetailCast>)
    fun showCrew(crew: List<DetailCast>)
    fun checkFav(response: Int?)
}