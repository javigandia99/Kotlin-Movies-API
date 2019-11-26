package com.jgc.primeraapplicacion.data.remote

import com.jgc.primeraapplicacion.model.MovieDetail
import com.jgc.primeraapplicacion.model.MovieResults
import com.jgc.primeraapplicacion.model.User
import retrofit2.Response

interface RemoteRepository {
    suspend fun login(username: String, password: String): User?
    
    suspend fun searchMovies(api_key: String, movie: String): Response<MovieResults>

    suspend fun getMoviesDetail(id: Int, api_key: String): Response<MovieDetail>

    suspend fun getMoviesCast(id: Int, api_key: String): Response<MovieDetail>
}