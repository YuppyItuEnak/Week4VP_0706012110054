package com.uc.week4_retrofit.adapter

import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4_retrofit.R
import com.uc.week4_retrofit.model.SpokenLanguage

class LanguageAdapter(private val dataset: List<SpokenLanguage>):
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvSpoken: TextView

        init {
            tvSpoken = view.findViewById(R.id.language)
        }
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.language, viewgroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSpoken.text = dataset[position].name
    }

    override fun getItemCount()= dataset.size
}