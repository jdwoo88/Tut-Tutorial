package com.example.myapplication.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.interfaces.ILoadMore
import com.example.myapplication.models.Item
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.list_row.view.*
import kotlinx.android.synthetic.main.loading_layout.view.*

internal class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var progressBar = itemView.progress_bar
}

internal class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtName = itemView.findViewById<TextView>(R.id.txt_name)
    var txtLength = itemView.findViewById<TextView>(R.id.txt_length)
}

class MyAdapter(
    var recyclerView: RecyclerView,
    var activity: Activity,
    var items: MutableList<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val VIEW_ITEMTYPE: Int = 0
    val VIEW_LOADINGTYPE: Int = 1

    internal var loadMore: ILoadMore? = null
    internal var isLoading: Boolean = false
    internal var visibleThreshold = 5
    internal var lastVisibleItem = 0
    internal var totalItemCount = 0

    init {
        var linearLayoutManger = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManger.itemCount
                lastVisibleItem = linearLayoutManger.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                    if (loadMore != null) {
                        loadMore!!.onLoadMore()
                    }
                    isLoading = true
                }
            }

        })
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].name == "") VIEW_LOADINGTYPE else VIEW_ITEMTYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_ITEMTYPE) {
            val view = LayoutInflater.from(activity).inflate(R.layout.item_layout, parent, false)
            return ItemViewHolder(view)
        }
        else if (viewType == VIEW_LOADINGTYPE) {
            val view = LayoutInflater.from(activity).inflate(R.layout.loading_layout, parent, false)
            return LoadingViewHolder(view)
        }

        return null!!
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            val item = items[position]
            holder.txtName.text = item!!.name
            holder.txtLength.text = item!!.length.toString()

        }
        else if (holder is LoadingViewHolder){
            holder.progressBar.isIndeterminate = true
        }
    }

    fun setLoaded() {
        isLoading = false
    }

    fun setLoadMore(iLoadMore: ILoadMore){
        this.loadMore = iLoadMore
    }
}