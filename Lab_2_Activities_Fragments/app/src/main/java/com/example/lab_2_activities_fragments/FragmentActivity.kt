package com.example.lab_2_activities_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class FragmentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var frame1: FrameLayout
    private lateinit var frame2: FrameLayout
    private lateinit var buttonAddFirst: Button
    private lateinit var buttonRemoveFirst: Button
    private lateinit var buttonAddSecond: Button
    private lateinit var buttonRemoveSecond: Button
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        frame1 = findViewById(R.id.frameLayout1)
        frame2 = findViewById(R.id.frameLayout2)
        buttonAddFirst = findViewById(R.id.button5)
        buttonAddSecond = findViewById(R.id.button6)
        buttonRemoveFirst = findViewById(R.id.button7)
        buttonRemoveSecond = findViewById(R.id.button8)
        buttonAddFirst.setOnClickListener(this)
        buttonAddSecond.setOnClickListener(this)
        buttonRemoveFirst.setOnClickListener(this)
        buttonRemoveSecond.setOnClickListener(this)

        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button5 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, firstFragment)
                    .commit()
            }
            R.id.button6 -> {
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, secondFragment)
                    .commit()
            }
            R.id.button7 -> {
                supportFragmentManager.beginTransaction().remove(firstFragment).commit()
            }
            R.id.button8 -> {
                supportFragmentManager.beginTransaction().remove(secondFragment).commit()
            }
        }
    }
}