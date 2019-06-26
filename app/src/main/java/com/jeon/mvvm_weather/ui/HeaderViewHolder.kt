package com.jeon.mvvm_weather.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeon.mvvm_weather.R
class HeaderViewHolder private constructor (view: View) : RecyclerView.ViewHolder(view) {



    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_header, parent, false)
            return HeaderViewHolder(view)
        }
    }

}