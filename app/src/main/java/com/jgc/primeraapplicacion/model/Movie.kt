package com.jgc.primeraapplicacion.model

data class Movie(
    val id: Int,
    val poster_path: String,
    val title: String,
    val release_date: String,
    val adult: Boolean,
    val popularity: Float,
    val vote_average: Float
)

data class MovieResults(val results: List<Movie>)