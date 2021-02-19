package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.button)

        btnEnter.setOnClickListener (){

            val tfName = findViewById<TextView>(R.id.editTextPersonName)

            val intent = Intent(this, BMI::class.java)

            intent.putExtra("personName", tfName.text.toString())
            startActivity(intent);
        }
    }
}