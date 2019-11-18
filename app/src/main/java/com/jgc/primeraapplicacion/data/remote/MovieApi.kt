package com.jgc.primeraapplicacion.data.remote

import com.jgc.primeraapplicacion.model.MovieDetail
import com.jgc.primeraapplicacion.model.MovieResults
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


// apikey == "6d247d2725f2627d9e371751ce4e8679"
interface MovieApi {
    @GET("search/movie")
    suspend fun searchMovies(@Query("api_key") api_key: String, @Query("query") movie: String): Response<MovieResults>

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(@Path("movie_id") id: Int, @Query("api_key") api_key: String): Response<MovieDetail>

    @GET("movie/{movie_id}/credits")
    suspend fun getMoviesCast(@Path("movie_id") id: Int, @Query("api_key") api_key: String): Response<MovieDetail>
}

object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    fun getMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApi::class.java)
    }
}
