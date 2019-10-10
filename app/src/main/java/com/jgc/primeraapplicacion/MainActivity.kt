package com.jgc.primeraapplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var countText: TextView
    private lateinit var myButton: Button
    private lateinit var profileButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countText = findViewById(R.id.count_textview)
        countText.text = getString(R.string.count_text)
        myButton = findViewById(R.id.first_buttom)
        profileButton = findViewById(R.id.profile_buttom)

        var count = 1

        myButton.setOnClickListener {
            incrementcount(count++)

        }

        profileButton.setOnClickListener {
            val profileintent = Intent(this, ProfileActivity::class.java)
            profileintent.putExtra("intent_name", "Valentino Rossi")
            profileintent.putExtra("intent_image", R.drawable.ghost)
            profileintent.putExtra("intent_city", "Tuvullia")
            profileintent.putExtra("intent_age", "46")

            startActivity(profileintent)
        }
    }

    fun incrementcount(count: Int) {
        var message = getString(R.string.button_pressed)
        Toast.makeText(MainActivity@ this, message, Toast.LENGTH_LONG).show()

        countText.text = count.toString()

    }
}