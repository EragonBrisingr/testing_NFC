package com.example.lab10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text


//global variables
//major
var major = ""
//languages
var languages = " "

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //checkboxes
        var langC = findViewById<CheckBox>(R.id.C)
        var langJava = findViewById<CheckBox>(R.id.Java)
        var langCpp = findViewById<CheckBox>(R.id.Cpp)
        var langKotlin = findViewById<CheckBox>(R.id.Kotlin)
        var langPy = findViewById<CheckBox>(R.id.Python)

        //radio group
        var radioB = findViewById<RadioGroup>(R.id.radioGroup)

        //submit button
        var submit = findViewById<Button>(R.id.Submit)

        radioB.setOnCheckedChangeListener{group, checkedID->
            when(checkedID){
                R.id.EE -> major= "Electrical Engineering"/*code*/
                R.id.CE-> major= "Computer Engineering"/*code*/
                R.id.CS-> major= "Computer Science"
            }
        }

        fun isCheck(){
            if(langC.isChecked) languages+="C "
            if(langJava.isChecked) languages+="Java "
            if(langCpp.isChecked) languages+="C++ "
            if(langKotlin.isChecked) languages+="Kotlin "
            if(langPy.isChecked) languages+="Python "
        }

        submit.setOnClickListener{
            isCheck()

            var intent = Intent(this, outputPage::class.java)
            intent.putExtra("major",major)
            intent.putExtra("languages", languages)
            startActivity(intent)

        }

    }
}


















