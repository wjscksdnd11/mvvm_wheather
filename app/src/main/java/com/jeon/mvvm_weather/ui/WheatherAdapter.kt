package com.jeon.mvvm_weather.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.jeon.mvvm_weather.datas.WheatherDay

class WheatherAdapter(val glide: RequestManager): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val DATA_VIEW_TYPE = 1
    private val HEADER_VIEW_TYPE = 2
    private var data:List<WheatherDay> = emptyList()

    fun replaceList(list : List<WheatherDay>){
        data = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType ==DATA_VIEW_TYPE ) DataViewHolder.create(parent,glide) else HeaderViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return data.size+1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, containsHeaderPos: Int) {
        val position = containsHeaderPos-1
        //data position -1 이면 header
        if(holder is DataViewHolder){
            holder.bind(data[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position==0) HEADER_VIEW_TYPE else DATA_VIEW_TYPE
    }


}
