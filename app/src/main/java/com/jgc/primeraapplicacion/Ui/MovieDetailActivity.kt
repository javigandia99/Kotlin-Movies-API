package com.jgc.primeraapplicacion.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jgc.primeraapplicacion.Model.Movie
import com.jgc.primeraapplicacion.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    val movie = Movie(
        idMovie = 1,
        imageMovie = "https://sm.ign.com/ign_es/feature/r/ready-play/ready-player-one-138-easter-eggs-and-pop-culture-references_xtve.jpg",
        tittle = "Ready One Player",
        release_date = "02/08/2018",
        genreMovie = "Action,Fantasy,Sci-Fi",
        overview = "In the year 2045, people can escape their harsh reality in the OASIS, " +
                "an immersive virtual world where you can go anywhere, do anything, be anyone-the only " +
                "limits are your own imagination. OASIS creator James Halliday left his immense fortune" +
                " and control of the Oasis to the winner of a contest designed to find a worthy heir. " +
                "When unlikely hero Wade Watts conquers the first challenge of the reality-bending treasure hunt," +
                "he and his friends-known as the High Five-are hurled into a fantastical universe of discovery and danger to save the OASIS and their world.",
        score = 10F

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setTitle(R.string.title_moviedetail)

        with(movie) {
            movie_tittle.text = tittle
            yearvalue_tittle.text = release_date
            genrevalue_tittle.text = genreMovie
            description_tittle.text = overview
            Picasso.get().load(imageMovie).into(movieImageView)
        }

    }

}
