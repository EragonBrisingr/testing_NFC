package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class outputPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_output_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //the variable intent automatically gets sent over apparently. all you have to do is give the value
        //of "intent" taken from previous page to a new variable in this page.
        var intent = intent

        var major = intent.getStringExtra("major").toString()

        var languages = intent.getStringExtra("languages").toString()

        var output = findViewById<TextView>(R.id.output)
        output.text = major + "\n" + languages

        val msg = "Application completed! :D"

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()


    }
}