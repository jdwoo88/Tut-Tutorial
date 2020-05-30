package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.MyAdapter
import com.example.myapplication.interfaces.ILoadMore
import com.example.myapplication.models.Item
import kotlinx.android.synthetic.main.activity_infinite_view.*
import java.util.*
import kotlin.collections.ArrayList

class InfiniteView : AppCompatActivity(), ILoadMore {

    var items: MutableList<Item> = ArrayList()
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_view)

        setTitle("Infinite View")

        random10Data()

        recycler_view_Infinite.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(recycler_view_Infinite, this, items)
        recycler_view_Infinite.adapter = adapter

        adapter.setLoadMore(this)
    }

    private fun random10Data() {
        for (i in 0..9){
            val name = UUID.randomUUID().toString()
            val item = Item(name, name.length)
            items.add(item)
        }
    }

    override fun onLoadMore() {
        if (items!!.size < 500){
            items!!.add(Item("", 0))
            adapter.notifyItemInserted(items!!.size - 1)
            Handler().postDelayed({
                items.removeAt(items!!.size - 1)
                adapter.notifyItemRemoved(items!!.size)

                val index = items!!.size
                val end = index+10

                for(i in index until end){
                    val name = UUID.randomUUID().toString()
                    var item = Item(name, name.length)
                    items.add(item)
                }

                adapter.notifyDataSetChanged()
                adapter.setLoaded()

            }, 3000)
        }
        else {
            Toast.makeText(this, "MAX DATA IS 500", Toast.LENGTH_SHORT).show()
        }
    }
}
