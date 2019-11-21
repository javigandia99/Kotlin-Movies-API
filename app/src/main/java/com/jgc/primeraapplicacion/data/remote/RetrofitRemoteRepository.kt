package com.jgc.primeraapplicacion.data.remote

import com.jgc.primeraapplicacion.model.MovieDetail
import com.jgc.primeraapplicacion.model.MovieResults
import com.jgc.primeraapplicacion.model.User
import retrofit2.Response

class RetrofitRemoteRepository(private val movieApi: MovieApi) : RemoteRepository {
    override suspend fun searchMovies(api_key: String, movie: String): Response<MovieResults> {
        return movieApi.searchMovies(api_key, movie)
    }

    override suspend fun getMoviesDetail(id: Int, api_key: String): Response<MovieDetail> {
        return movieApi.getMoviesDetail(id, api_key)
    }

    override suspend fun getMoviesCast(id: Int, api_key: String): Response<MovieDetail> {
        return movieApi.getMoviesCast(id, api_key)
    }

    override suspend fun login(username: String, password: String): User? {
        return if (username == "root" && password == "1234") {
            User(username, password)
        } else {
            null
        }
    }

}