package com.example.lab_2_activities_fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView2)
        button = findViewById(R.id.button4)
        button.setOnClickListener {
            val text = editText.text.toString()
            val intent = Intent()
            intent.putExtra(KEY_TEXT, text)
            setResult(RESULT_OK, intent)
            finish()
        }
        editText = findViewById(R.id.editTextTextPersonName)

        intent.let {
            if (it.hasExtra(MainActivity.KEY_MESSAGE)) {
                textView.text = it.getStringExtra(MainActivity.KEY_MESSAGE)
            }
        }
    }

    companion object {
        const val KEY_TEXT = "v"
    }

}