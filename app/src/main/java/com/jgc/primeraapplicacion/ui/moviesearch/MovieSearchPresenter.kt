package com.jgc.primeraapplicacion.ui.moviesearch

import com.jgc.primeraapplicacion.data.remote.RetrofitFactory
import com.jgc.primeraapplicacion.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView) {

    fun searchClicked(searchmovie: String) {
        if (searchmovie.isEmpty()) return

        val movieApi = RetrofitFactory.getMovieApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = movieApi.searchMovies("6d247d2725f2627d9e371751ce4e8679", searchmovie)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responsemovies = response.body()?.results!!
                    if (listOf(responsemovies).isEmpty()) {
                        view.showEmpty()
                        return@withContext
                    }
                    view.showMovies(responsemovies)
                } else {
                    view.showError()
                }
            }
        }
    }

    fun movieClicked(movie: Movie) {
        view.openMovieDetail(movie.id)
    }
}

interface MovieSearchView {
    fun showMovies(movies: List<Movie>)
    fun openMovieDetail(id: Int)
    fun showError()
    fun showEmpty()
}