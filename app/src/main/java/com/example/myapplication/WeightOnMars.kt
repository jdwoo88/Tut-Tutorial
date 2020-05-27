package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.wiegth_on_mars.*

class WeightOnMars : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wiegth_on_mars)

        btnShowWeight.setOnClickListener {
            var result:Double = calculateWeight(txtEnterWeight.text.toString().toDouble())

            txtResult.text = "Your weight in Mars is " + result.toString()
        }

        Log.d("WeightOnMars Activity", "onCreate Completed")
    }

    override fun onPause() {
        super.onPause()

        Log.d("WeightOnMars Activity", "onPause Completed")
    }

    override fun onPostResume() {
        super.onPostResume()

        Log.d("WeightOnMars Activity", "onPostResume Completed")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("WeightOnMars Activity", "onDestroy Completed")
    }

    override fun onStart() {
        super.onStart()

        Log.d("WeightOnMars Activity", "onStart Completed")
    }

    override fun onStop() {
        super.onStop()

        Log.d("WeightOnMars Activity", "onStop Completed")
    }

    fun calculateWeight(userWeight: Double) : Double{
        return userWeight * 0.38
    }
}