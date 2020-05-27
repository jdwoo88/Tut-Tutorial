package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.run_activity.*

class RunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.run_activity)

        var name:String = intent.getStringExtra("Name")
        var age:Int = intent.getIntExtra("Age", 0)

        // OR

        var extraVal = intent.extras
        if (extraVal != null){
            var name2:String = extraVal.get("Name").toString()
            var age2:Int = extraVal.getInt("Age")
        }

        Log.d("RunActivity", name + " " + age)

        btnReturnToPrevious.setOnClickListener {
            var returnIntent = this.intent
            returnIntent.putExtra("message","RETURN FROM RUN ACTIVITY - BUTTON CLICK")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
