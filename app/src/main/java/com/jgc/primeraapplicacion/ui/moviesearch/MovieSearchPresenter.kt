package com.jgc.primeraapplicacion.ui.moviesearch

import com.jgc.primeraapplicacion.data.remote.RemoteRepository
import com.jgc.primeraapplicacion.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView, private val remoteRepository: RemoteRepository) {

    fun searchClicked(searchMovie: String) {
        if (searchMovie.isEmpty()) return
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                remoteRepository.searchMovies("6d247d2725f2627d9e371751ce4e8679", searchMovie)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseMovies = response.body()?.results!!
                    if (listOf(responseMovies).isEmpty()) {
                        view.showEmpty()
                        return@withContext
                    }
                    view.showMovies(responseMovies)
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