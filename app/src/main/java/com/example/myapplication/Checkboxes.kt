package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.checkboxes.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.wiegth_on_mars.*

class Checkboxes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkboxes)

        imgJW.setColorFilter(Color.BLUE)

        imgJW.setOnClickListener {
            imgJW.clearColorFilter()
            Toast.makeText(this, "Image Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onCheckBoxClicked (view: View){
        var isChecked = (view as CheckBox).isChecked
        when (view.id){
            R.id.chkRed -> {
                Log.d("Checkbox", "Red is " + (if (isChecked) "Checked" else "Unchecked"))
            }
            R.id.chkOrange -> {
                Log.d("Checkbox", "Orange is " + (if (isChecked) "Checked" else "Unchecked"))
            }
            R.id.chkYellow -> {
                Log.d("Checkbox", "Yellow is " + (if (isChecked) "Checked" else "Unchecked"))
            }
        }
    }
}
