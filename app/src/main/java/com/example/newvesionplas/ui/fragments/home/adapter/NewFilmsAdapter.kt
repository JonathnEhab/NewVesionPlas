package com.example.newvesionplas.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.pojo.NewFilms
import com.example.newvesionplas.databinding.FilmItemBinding

class NewFilmsAdapter(private val onItemClick :(String)-> Unit) : ListAdapter<NewFilms, NewFilmsAdapter.ViewHolder>(
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
        fun bind(newFilms: NewFilms) {
            itemBinding.titleTxt.text = newFilms.title
            itemBinding.scoreTxt.text = newFilms.imdb_rating
            Glide.with(itemBinding.root.context).load(newFilms.poster).into(itemBinding.pic)
            itemBinding.root.setOnClickListener {
                onItemClick(newFilms.id.toString())
            }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<NewFilms>() {
        override fun areItemsTheSame(
            oldItem: NewFilms,
            newItem: NewFilms
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewFilms,
            newItem: NewFilms
        ): Boolean {
            return oldItem == newItem
        }
    }





}