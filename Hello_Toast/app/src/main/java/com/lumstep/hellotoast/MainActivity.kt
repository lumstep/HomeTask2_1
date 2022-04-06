package com.lumstep.hellotoast

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var showCount: TextView
    private lateinit var buttonToast: Button
    private lateinit var buttonCount: Button

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCount = findViewById(R.id.show_count)
        buttonToast = findViewById(R.id.button_toast)
        buttonCount = findViewById(R.id.button_count)

        buttonToast.setOnClickListener {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }
        buttonCount.setOnClickListener {
            count++
            showCount.text = count.toString()
        }
    }

}