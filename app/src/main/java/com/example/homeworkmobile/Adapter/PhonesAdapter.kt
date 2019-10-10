package com.example.homeworkmobile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworkmobile.R
import com.example.homeworkmobile.model.Phone
import kotlinx.android.synthetic.main.layout_phone.view.*

class PhonesAdapter(val phones : List<Phone>) : RecyclerView.Adapter<PhonesAdapter.PhoneViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_phone, parent, false)
        )
    }

    override fun getItemCount(): Int = phones.size

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {

        val phone = phones[position]
        holder.view.txtPhoneName.text = phone.name
        holder.view.txtPhonePrice.text = "$ " + phone.price.toString()
        Glide.with(holder.view.context)
            .load(phone.imageUrl)
            .into(holder.view.imgPhone)

    }

    class PhoneViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}