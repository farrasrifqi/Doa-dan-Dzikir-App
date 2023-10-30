package com.idn.doadandzikirapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.Model.DoadanDzikirItem
import com.idn.doadandzikirapp.R

class DoadanDzikirAdapter : RecyclerView.Adapter<DoadanDzikirAdapter.DzikirViewHolder>() {

    private val listData = ArrayList<DoadanDzikirItem>()

    fun setData(list: List<DoadanDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textJudul = view.findViewById<TextView>(R.id.tv_desc)
        val textIsi = view.findViewById<TextView>(R.id.tv_lafaz)
        val textTerjemah = view.findViewById<TextView>(R.id.tv_terjemah)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent, false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            textJudul.text = listData[position].title
            textIsi.text = listData[position].isi
            textTerjemah.text = listData[position].terjemah
        }

    }


}