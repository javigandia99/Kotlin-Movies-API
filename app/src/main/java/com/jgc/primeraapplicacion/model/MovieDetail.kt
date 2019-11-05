package com.jgc.primeraapplicacion.model

data class MovieDetail(
    val id: Int,
    val poster_path: String,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val title: String,
    val release_date: String,
    val genres: List<ListGenres>,
    val overview: String,
    val vote_average: Float

)

data class ListGenres( val name : String)

data class MovieDetailCast(val name: String, val job: String)