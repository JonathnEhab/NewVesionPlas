package com.example.newvesionplas.ui.fragments.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.pojo.UpcomingFilms
import com.example.newvesionplas.databinding.FilmItemBinding

class SearchAdapter(private val onItemClick :(String)-> Unit) : ListAdapter<UpcomingFilms, SearchAdapter.ViewHolder>(
    CategoryDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

    }


    inner class ViewHolder(private val itemBinding: FilmItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(upComing: UpcomingFilms) {
            itemBinding.titleTxt.text = upComing.title
            itemBinding.scoreTxt.text = upComing.imdb_rating
            Glide.with(itemBinding.root.context).load(upComing.poster).into(itemBinding.pic)
            itemBinding.root.setOnClickListener {
                onItemClick(upComing.id.toString())
            }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<UpcomingFilms>() {
        override fun areItemsTheSame(
            oldItem: UpcomingFilms,
            newItem: UpcomingFilms
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UpcomingFilms,
            newItem: UpcomingFilms
        ): Boolean {
            return oldItem == newItem
        }
    }



}