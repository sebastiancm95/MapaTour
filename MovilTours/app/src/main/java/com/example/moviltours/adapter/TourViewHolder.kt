package com.example.moviltours.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviltours.Tour
import com.example.moviltours.databinding.ItemTourBinding

class TourViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemTourBinding.bind(view)

    fun render(tourModel: Tour, onClickListener: (Tour) -> Unit) {
        binding.tvTourName.text = tourModel.name
        binding.tvTourPrice.text = tourModel.price
        Glide.with(binding.ivTour.context).load(tourModel.photo).into(binding.ivTour)
        itemView.setOnClickListener { onClickListener(tourModel) }
    }
}