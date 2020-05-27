package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val RUN_ACTIVITY_REQUEST_CODE:Int = 911 // RUN ACTIVITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btnAddInventory.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        btnWeightOnMars.setOnClickListener {
            startActivity(Intent(this, WeightOnMars::class.java))
        }

        btnCheckBox.setOnClickListener {
            startActivity(Intent(this, Checkboxes::class.java))
        }

        btnLayout.setOnClickListener {
            startActivity(Intent(this, LayoutExample::class.java))
        }

        btnPassData.setOnClickListener {
            var intent:Intent = Intent(this, RunActivity::class.java)
            intent.putExtra("Name", "John")
            intent.putExtra("Age", 31)

            startActivityForResult(intent, RUN_ACTIVITY_REQUEST_CODE)
        }

        btnListViews.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        btnSharedPref.setOnClickListener {
            startActivity(Intent(this, SharedPreferencesActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RUN_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var message = data?.extras?.getString("message")
            if (message != null) Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
