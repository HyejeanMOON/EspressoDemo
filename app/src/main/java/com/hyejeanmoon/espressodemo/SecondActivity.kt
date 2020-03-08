package com.hyejeanmoon.espressodemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val arguments = intent.getStringExtra("data") ?: "none"
        Log.d("SecondActivity", arguments)
        val textView: TextView = findViewById(R.id.textViewInSecond)

        textView.text = arguments

        val strings = resources.getStringArray(R.array.spinner)

        val textView2 = findViewById<TextView>(R.id.textViewInSecondTwo)

        val spinner = findViewById<Spinner>(R.id.spinner)

        spinner.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                strings
            )

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textView2.text = strings[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

}