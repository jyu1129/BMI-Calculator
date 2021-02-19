package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMI : AppCompatActivity() {
    var bmiIndex : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val tvName = findViewById<TextView>(R.id.textViewName2)
        val personName = intent?.getStringExtra("personName")
        tvName.text = personName

        if(savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmi")
            val tvStatus = findViewById<TextView>(R.id.textViewStatusDisplay)
            tvStatus.text = getStatus()
        }

        val btnCal = findViewById<Button>(R.id.button2)
        btnCal.setOnClickListener() {
            val weight = findViewById<TextView>(R.id.editTextWeight).text.toString()
            val height = findViewById<TextView>(R.id.editTextHeight).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() / 100 * height.toDouble() / 100)

            val tvStatus = findViewById<TextView>(R.id.textViewStatusDisplay)
            tvStatus.text = getStatus()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmi", bmiIndex)
    }

    private fun getStatus():String{
        return when {
            bmiIndex < 18.5 -> "Underweight"
            bmiIndex < 24.9 -> "Normal weight"
            bmiIndex < 29.9 -> "Overweight"
            bmiIndex < 34.9 -> "Obesity class I"
            bmiIndex < 39.9 -> "Obesity class II"
            else -> "Obesity class III"
        }
    }
}