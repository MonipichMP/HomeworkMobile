package com.example.homeworkmobile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkmobile.R
import com.example.homeworkmobile.model.Brand
import kotlinx.android.synthetic.main.layout_brand.view.*

class BrandsAdapter(val brands: List<Brand>) :
    RecyclerView.Adapter<BrandsAdapter.BrandViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        return BrandViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_brand, parent, false)
        )
    }

    override fun getItemCount(): Int = brands.size

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {

        val brand = brands[position]
        holder.view.txtBrandName.text = brand.name

    }

    class BrandViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}