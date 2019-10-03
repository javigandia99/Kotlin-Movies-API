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
        var  countText: TextView = findViewById(R.id.count_text)
        countText.text = getString(R.string.counttext)
        val myButton: Button = findViewById(R.id.mybutton)
        var count = 0
        myButton.setOnClickListener{
            var message = getString(R.string.button_pressed)
            Toast.makeText(MainActivity@this,message,Toast.LENGTH_LONG).show()
            count++
           countText.text = count.toString()

        }
    }

}
