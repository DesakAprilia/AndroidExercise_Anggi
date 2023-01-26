package com.kampusmerdeka.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MortyAdapter(val dataRick: List<ResultsItem?>?) : RecyclerView.Adapter<MortyAdapter.MyViewHolder>() {
    class MyViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val dataImage = view.findViewById<ImageView>(R.id.item_image_rick)
        val dataNama = view.findViewById<TextView>(R.id.item_name_rick)
        val dataStatus = view.findViewById<TextView>(R.id.item_status_rick)
        val dataSpesies = view.findViewById<TextView>(R.id.item_spesies_rick)
        val dataGender = view.findViewById<TextView>(R.id.item_gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_rick,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dataNama.text = dataRick?.get(position)?.name
        holder.dataStatus.text = dataRick?.get(position)?.status
        holder.dataSpesies.text = dataRick?.get(position)?.species
        holder.dataGender.text = dataRick?.get(position)?.gender

        Glide.with(holder.dataImage)
            .load(dataRick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.dataImage)

        holder.itemView.setOnClickListener {
            val name = dataRick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        if (dataRick != null){
            return dataRick.size
        }
        return 0
    }
}