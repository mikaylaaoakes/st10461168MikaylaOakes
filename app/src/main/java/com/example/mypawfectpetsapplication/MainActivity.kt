package com.example.mypawfectpetsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("FEED_MESSAGE", "I am hungry")
            startActivity(intent)
        }
    }
}