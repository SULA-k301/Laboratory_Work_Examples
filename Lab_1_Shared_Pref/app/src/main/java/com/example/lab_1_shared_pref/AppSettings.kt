package com.example.lab_1_shared_pref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity


private const val SHARED_PREF_NAME = "pref.settings"
private const val KEY_TEXT = "KEY_TEXT"

class AppSettings(context: Context) {
    private var sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)


    fun saveText(text: String){
        val editor = sharedPref.edit()
        editor.putString(KEY_TEXT, text)
        editor.apply()
    }

    fun restoreText() : String? {
        return sharedPref.getString(KEY_TEXT, "Default Value")
    }

}