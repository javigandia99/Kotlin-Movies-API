package com.jgc.primeraapplicacion.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jgc.primeraapplicacion.Model.Movie
import com.jgc.primeraapplicacion.R
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setTitle(R.string.title_movielist)
        val movieList = listOf(
            (Movie(
                1,
                "https://sm.ign.com/ign_es/feature/r/ready-play/ready-player-one-138-easter-eggs-and-pop-culture-references_xtve.jpg",
                "Ready One Player ",
                "02/08/2018",
                "Action, Fantasy",
                "",
                10F
            )),
            (Movie(
                2,
                "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg",
                "Titanic",
                "09/01/1997",
                "Drama, Romance",
                "84 years later, a 100 year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, " +
                        "Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912," +
                        " on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother," +
                        " Ruth DeWitt Bukater, and her fiancé, Caledon Hockley. Meanwhile, " +
                        "a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. " +
                        "And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning.",
                10F
            )),
            (Movie(
                3,
                "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "Joker",
                "04/10/2019",
                "Crime, Drama, Thriller",
                "Joker centers around an origin of the iconic arch nemesis and is an original, " +
                        "standalone story not seen before on the big screen. Todd Phillips' exploration of Arthur Fleck (Joaquin Phoenix), " +
                        "a man disregarded by society, is not only a gritty character study, but also a broader cautionary tale.",
                9.8F
            )),
            (Movie(
                4,
                "https://m.media-amazon.com/images/M/MV5BMTYzMDM4NzkxOV5BMl5BanBnXkFtZTgwNzM1Mzg2NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "Toy Story 4",
                "21/07/2019",
                " Animation, Adventure, Comedy",
                "Woody," +
                        " Buzz Lightyear and the rest of the gang embark on a road trip with Bonnie and a new toy named Forky." +
                        "s The adventurous journey turns into an unexpected reunion as Woody's slight detour leads him to his long-lost friend Bo Peep." +
                        " As Woody and Bo discuss the old days, they soon start to realize that they're two worlds apart when it comes to what they want from life as a toy.",
                8.4F
            )),
            (Movie(
                5,
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,665,1000_AL_.jpg",
                "Matrix",
                "23/06/1999",
                "Action, Sci-Fi",
                "",
                10F
            )),
            (Movie(
                6,
                "https://m.media-amazon.com/images/M/MV5BZjJiYTExOTAtNWU0Yi00NzJjLTkwOTgtOTU2NWM1ZjJmYWVhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SY1000_SX675_AL_.jpg",
                "Maleficient",
                "18/10/2019",
                " Adventure, Family, Fantasy",
                "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials," +
                        "unexpected allies, and dark new forces at play.",
                7.1F
            ))
        )
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MoviesAdapter(movieList)
       // recycler_view.addItemDecoration(this,DividerItemDecoration.VERTICAL)
        recycler_view.setHasFixedSize(true)

    }
}
