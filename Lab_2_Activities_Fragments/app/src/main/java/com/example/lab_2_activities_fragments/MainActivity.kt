package com.example.lab_2_activities_fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button9: Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView

    private val secondActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val result = "Result: ${result.data?.getStringExtra(SecondActivity.KEY_TEXT)}"
            textView.text = result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Zeek", "onCreate")

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button9 = findViewById(R.id.button9)
        editText = findViewById(R.id.editTextText)
        textView = findViewById(R.id.textView3)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Zeek", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Zeek", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Zeek", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Zeek", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Zeek", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Zeek", "onDestroy")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

            R.id.button2 -> {
                val text = editText.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(KEY_MESSAGE, text)
                startActivity(intent)
            }

            R.id.button3 -> {
                val intent = Intent(this, SecondActivity::class.java)
                secondActivityResult.launch(intent)
            }

            R.id.button9 ->{
                val intent = Intent(this, FragmentActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_MESSAGE = "KEY_MESSAGE"
    }
}