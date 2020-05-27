package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.shared_preferences_activity.*
import kotlinx.android.synthetic.main.wiegth_on_mars.*

class SharedPreferencesActivity : AppCompatActivity() {
    val PREF_NAME = "firstApp"
    var shared_pref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shared_preferences_activity)

        shared_pref = getSharedPreferences(PREF_NAME, 0)
        var editor: SharedPreferences.Editor = (shared_pref as SharedPreferences)!!. edit()

        btnSave.setOnClickListener {
            if (!TextUtils.isEmpty(txtSource.text.toString())) {
                // NOT EMPTY, WRITE TO SHARED PREFERENCE
                editor.putString("Message", txtSource.text.toString())
                editor.commit()
            }
            else{
                Toast.makeText(this, "Please enter something.", Toast.LENGTH_SHORT).show()
            }
        }

        btnRetrieve.setOnClickListener {
            if (shared_pref!!.contains("Message")){
                txtDestination.text = shared_pref!!.getString("Message", "")
            }
        }
    }
}
