package com.example.moviltours.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviltours.R
import com.example.moviltours.Tour

class TourAdapter(private val tourList: List<Tour>) : RecyclerView.Adapter<TourViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TourViewHolder(layoutInflater.inflate(R.layout.item_tour, parent, false))
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val item = tourList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = tourList.size
}