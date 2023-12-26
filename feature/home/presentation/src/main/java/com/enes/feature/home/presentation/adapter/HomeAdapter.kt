package com.enes.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.enes.feature.home.domain.entity.ResultEntity
import com.enes.feature.home.presentation.databinding.ItemHomeBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewRickAndMortyHolder>() {

    private var list: List<ResultEntity> = emptyList()
    private var setItemClickListener: (ResultEntity) -> Unit = {}

    inner class ViewRickAndMortyHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResultEntity) = with(binding) {
            title.text = item.species.orEmpty()
            subtitleFirst.text = item.status.orEmpty()
            subtitleSecond.text = item.name
            imageView.load(item.image)
            root.setOnClickListener { setItemClickListener.invoke(item) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewRickAndMortyHolder {
        return ViewRickAndMortyHolder(
            ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewRickAndMortyHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun submitList(newList: List<ResultEntity>) {
        list = newList
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: (ResultEntity) -> Unit) {
        setItemClickListener = listener
    }


}