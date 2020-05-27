package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // data source
        var names: Array<String> = arrayOf("John", "Peter", "Philip", "Arlene", "Gil", "Dara", "Tonet", "Astrid")

        // data adapter
        var namesAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        // set data
        lstView.adapter = namesAdapter

        lstView.setOnItemClickListener { parent, view, position, id ->
            var selectedName: String = lstView.getItemAtPosition(position).toString()
            Toast.makeText(this, "ID: $id; Name: $selectedName", Toast.LENGTH_SHORT).show()
        }
    }
}
