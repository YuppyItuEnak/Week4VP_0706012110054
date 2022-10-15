package com.uc.week4_retrofit.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4_retrofit.R
import com.uc.week4_retrofit.helper.Const
import com.uc.week4_retrofit.model.ProductionCompany

class CompanyAdapter(private val dataset: List<ProductionCompany>):
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvCom: ImageView

        init {
            tvCom = view.findViewById(R.id.CompanyView)
        }
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewgroup.context).inflate(R.layout.company, viewgroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.tvCom.context).load(Const.IMG_URL+dataset[position].logo_path).into(holder.tvCom)
    }

    override fun getItemCount() = dataset.size
}