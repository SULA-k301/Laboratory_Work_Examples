package com.example.lab_1_shared_pref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var buttonSave: Button
    private lateinit var buttonRestore: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    private lateinit var appSettings: AppSettings

    private val buttonSaveOnClick = View.OnClickListener {
        val text = editText.text.toString()
        textView.text = text
        appSettings.saveText(text)
    }

    private val buttonRestoreOnClick = View.OnClickListener {
        textView.text = appSettings.restoreText()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        buttonSave = findViewById(R.id.buttonSave)
        buttonRestore = findViewById(R.id.buttonRestore)

        buttonSave.setOnClickListener(buttonSaveOnClick)
        buttonRestore.setOnClickListener(buttonRestoreOnClick)

        appSettings = AppSettings(this)
    }
}