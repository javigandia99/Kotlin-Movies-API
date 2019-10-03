package com.jgc.primeraapplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  helloText: TextView = findViewById(R.id.hellotext)

        val myButton: Button = findViewById(R.id.mybutton)
        myButton.setOnClickListener{
            var message = getString(R.string.button_pressed)
            Toast.makeText(MainActivity@this,message,Toast.LENGTH_LONG).show()


        }
    }

}
