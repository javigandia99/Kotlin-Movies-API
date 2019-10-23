package com.jgc.primeraapplicacion.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.jgc.primeraapplicacion.R

class ProfileActivity : AppCompatActivity() {
    private lateinit var nameText: TextView
    private lateinit var imageView: ImageView
    private lateinit var cityText: TextView
    private lateinit var ageText: TextView
    private lateinit var descriptionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setTitle(R.string.title_profile)

        nameText = findViewById(R.id.profile_nameView)
        imageView = findViewById(R.id.profile_imageView)
        cityText = findViewById(R.id.profile_city)
        ageText = findViewById(R.id.profile_age)
        descriptionText = findViewById(R.id.profile_description)

        val name = intent.extras?.getString("intent_name")
        val image = intent.getIntExtra("intent_image", 1)
        val city = intent.extras?.getString("intent_city")
        val age = intent.extras?.getString("intent_age")
        val description = intent.extras?.getString("intent_description")

        nameText.text = name
        imageView.setImageResource(image)
        cityText.text = city
        ageText.text = age
        descriptionText.text = description
        
    }
}
