package com.jgc.primeraapplicacion.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jgc.primeraapplicacion.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.title_main)


        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottom_navigation_bar.setupWithNavController(navController)

        bottom_navigation_bar.setOnClickListener {
            val profileintent = Intent(this, ProfileActivity::class.java)
            profileintent.putExtra("intent_name", "Valentino Rossi")
            profileintent.putExtra("intent_image", R.drawable.valentino_rossi)
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
    }
}