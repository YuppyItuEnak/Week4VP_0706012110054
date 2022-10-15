package com.uc.week4_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4_retrofit.R
import com.uc.week4_retrofit.model.Genre

class GenreAdapter(private val dataset: List<Genre>):
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvGenre: TextView

        init {
            tvGenre = view.findViewById(R.id.tv_genre)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.genre, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvGenre.text = dataset[position].name
    }


}