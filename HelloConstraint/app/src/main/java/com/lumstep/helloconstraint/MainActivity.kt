package com.lumstep.helloconstraint


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var showCount: TextView
    private lateinit var buttonToast: Button
    private lateinit var buttonZero: Button

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showCount = findViewById(R.id.show_count)
        buttonToast = findViewById(R.id.button_toast)
        buttonZero = findViewById(R.id.button_zero)

        buttonToast.setOnClickListener {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }
        buttonZero.setOnClickListener {
            count = 0
            @Suppress("DEPRECATION")
            buttonZero.setBackgroundColor(resources.getColor(R.color.gray))
            showCount.text = count.toString()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onResume() {
        super.onResume()

        @Suppress("DEPRECATION")
        when (count) {
            0 -> buttonZero.setBackgroundColor(resources.getColor(R.color.gray))
            else -> buttonZero.setBackgroundColor(resources.getColor(R.color.purple_200))
        }

        showCount.text = count.toString()
    }

    fun count(view: View) { //onClick method for button_count (it is necessary for task)
        if (count == 0) @Suppress("DEPRECATION") buttonZero.setBackgroundColor(resources.getColor(R.color.purple_200))

        count++
        showCount.text = count.toString()
    }
}