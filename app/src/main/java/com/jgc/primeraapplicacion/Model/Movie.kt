package com.jgc.primeraapplicacion.Model

data class Movie(
    val idMovie: Int,
    val imageMovie: String,
    val tittle: String,
    val release_date: String,
    val genreMovie: String,
    val overview: String,
    val score: Float
)