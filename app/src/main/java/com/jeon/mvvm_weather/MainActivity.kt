package com.jeon.mvvm_weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jeon.mvvm_weather.ui.WheatherAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: WheatherViewModel
    lateinit var adapter: WheatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProviders.of(this).get(WheatherViewModel::class.java)
        initAdapter()

        viewmodel.wheatherDayList.observe(this, Observer {
            adapter.replaceList(it)
        })
        viewmodel.loadDatas("se")

    }

    private fun initAdapter() {
        adapter = WheatherAdapter(Glide.with(this))
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter

    }

}
