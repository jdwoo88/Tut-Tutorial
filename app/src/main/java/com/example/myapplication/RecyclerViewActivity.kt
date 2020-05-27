package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.datas.PersonListAdapter
import com.example.myapplication.models.Person
import kotlinx.android.synthetic.main.recycler_view_activity.*

class RecyclerViewActivity : AppCompatActivity() {

    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        rvPerson.layoutManager = layoutManager
        rvPerson.adapter = adapter

        for (i in 0..20){
            val person:Person = Person("Person #$i", i)
            personList!!.add(person)
        }

        adapter!!.notifyDataSetChanged()
    }
}
