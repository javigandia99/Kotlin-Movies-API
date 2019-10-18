package com.jgc.primeraapplicacion.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.jgc.primeraapplicacion.R

class MainActivity : AppCompatActivity() {

    private lateinit var countText: TextView
    private lateinit var myButton: Button
    private lateinit var profileButton: Button
    private lateinit var movieListButton: Button
    private lateinit var movieDetailButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countText = findViewById(R.id.count_textview)
        countText.text = getString(R.string.count_text)
        myButton = findViewById(R.id.first_buttom)
        profileButton = findViewById(R.id.profile_buttom)
        movieListButton = findViewById(R.id.movielist_buttom)
        movieDetailButton = findViewById(R.id.moviedetail_buttom)

        var count = 1

        myButton.setOnClickListener {
            incrementcount(count++)

        }

        profileButton.setOnClickListener {
            val profileintent = Intent(this, ProfileActivity::class.java)
            profileintent.putExtra("intent_name", "Valentino Rossi")
            profileintent.putExtra(
                "intent_image",
                R.drawable.valentino_rossi
            )
            profileintent.putExtra("intent_city", "Tuvullia")
            profileintent.putExtra("intent_age", "40")
            profileintent.putExtra(
                "intent_description", "Lorem Ipsum is simply dummy text of the printing and t" +
                        "ypesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                        " It has survived not only five centuries, but also the leap into electronic typesetting," +
                        " remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset" +
                        " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
            startActivity(profileintent)
        }
        movieListButton.setOnClickListener {
            val movielistintent = Intent(this, MovieListActivity::class.java)
            startActivity(movielistintent)
        }

        movieDetailButton.setOnClickListener {
            val moviedetailintent = Intent(this, MovieDetailActivity::class.java)
            startActivity(moviedetailintent)
        }
    }

    fun incrementcount(count: Int) {
        var message = getString(R.string.button_pressed)
        Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()

        countText.text = count.toString()

    }
}