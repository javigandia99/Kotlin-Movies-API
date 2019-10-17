package com.jgc.primeraapplicacion.Model

import android.media.Image

data class Movie(
    val idMovie: Int,
    val imageMovie: Int,
    val tittle: String,
    val release_date: String,
    val genreMovie: String,
    val overview: String
)