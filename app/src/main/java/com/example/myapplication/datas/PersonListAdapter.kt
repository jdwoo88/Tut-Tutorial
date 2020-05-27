package com.example.myapplication.datas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Person

class PersonListAdapter(private val list: ArrayList<Person>, private val context: Context): RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person){
            var name: TextView = itemView.findViewById(R.id.txtName) as TextView
            var age: TextView = itemView.findViewById(R.id.txtAge) as TextView

            name.text = person.Name
            age.text = person.Age.toString()

            itemView.setOnClickListener{
                Toast.makeText(context, ("Hi! " + name.text), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)

        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }
}