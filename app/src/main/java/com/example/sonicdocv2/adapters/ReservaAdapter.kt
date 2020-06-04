package com.example.sonicdocv2.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sonicdocv2.models.Reserva

class ReservaAdapter(val movies: List<Reserva>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<MoviePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePrototype {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviePrototype, position: Int) {
        TODO("Not yet implemented")
    }

}

class MoviePrototype(itemView : View) : RecyclerView.ViewHolder(itemView) {

}

interface OnItemClickListener {
    fun onItemClicked(reserva: Reserva)
}