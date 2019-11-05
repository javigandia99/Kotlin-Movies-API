package com.jgc.primeraapplicacion.data

import com.jgc.primeraapplicacion.model.Movie
import com.jgc.primeraapplicacion.model.MovieDetail
import com.jgc.primeraapplicacion.model.MovieResults
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("search/movie")
    suspend fun searchMovies(@Query("api_key") api_key : String,@Query("query") movie: String) : Response<MovieResults>

// apikey == "6d247d2725f2627d9e371751ce4e8679"
    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(@Path("movie_id") id: Int,@Query("api_key") api_key : String): Response<MovieDetail>
}

object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApi::class.java)
    }
}