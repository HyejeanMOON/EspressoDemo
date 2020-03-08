package com.hyejeanmoon.espressodemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)

        val button = findViewById<Button>(R.id.btnSend)
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", editText.text.toString())
            Log.d("MainActivity", editText.text.toString())
            intent.setClass(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
