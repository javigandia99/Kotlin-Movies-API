package com.jgc.primeraapplicacion.model

data class Movie(
    val id: Int,
    val poster_path: String,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val title: String,
    val release_date: String,
    val genre_ids: String,
    val overview: String,
    val vote_average: Float

)