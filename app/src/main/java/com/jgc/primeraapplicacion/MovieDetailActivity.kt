package com.jgc.primeraapplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jgc.primeraapplicacion.Model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    val movie = Movie(
        idMovie = 1,
        imageMovie = R.drawable.valentino_rossi,
        tittle = "Ready One Player",
        release_date = "2018",
        genreMovie = "Action,Fantasy,Sci-Fi",
        overview = "The data keyword provides functions that allow destructuring declarations. In short, it creates a function for every property so we can do things like this:"


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        with(movie) {
        movie_tittle.text = tittle
        yearvalue_tittle.text = release_date
        genrevalue_tittle.text = genreMovie
        description_tittle.text = overview
    }

    }


}
