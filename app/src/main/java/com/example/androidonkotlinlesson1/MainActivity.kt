package com.example.androidonkotlinlesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<TextInputEditText>(R.id.input_text)
        val btn = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.message)
        val btnFragment = findViewById<Button>(R.id.btn_fragment)

        btn.setOnClickListener {
            val message = editText.text
            when {
                message == null -> textView.text = "Введите текст"
                message.length > 5 -> textView.text = message
                else -> textView.text = "Введите более 5 символов"
            }
        }

        btnFragment.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, BlankFragment.Companion.newInstance())
                .addToBackStack("1")
                .commit()
        }
    }
}