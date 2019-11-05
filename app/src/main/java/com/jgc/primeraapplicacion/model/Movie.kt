package com.jgc.primeraapplicacion.model

data class Movie(
    val id: Int,
    val poster_path: String,
    val title: String,
    val release_date: String,
    val overview: String,
    val vote_average: Float
)