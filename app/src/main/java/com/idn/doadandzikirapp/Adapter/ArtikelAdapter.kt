package com.idn.doadandzikirapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikirapp.Model.Artikel
import com.idn.doadandzikirapp.Utils.OnItemCallback
import com.idn.doadandzikirapp.databinding.ItemArtikelBinding

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArticleViewHolder> () {

    private var listArtikel = ArrayList<Artikel>()
    private var onItemCalBack : OnItemCallback? = null
    fun setData(list : List<Artikel>){
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCalBack = onItemCallback
    }


    inner class ArticleViewHolder(val view: ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount() = listArtikel.size
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener { onItemCalBack?.onItemClicked(data)
        } }
}