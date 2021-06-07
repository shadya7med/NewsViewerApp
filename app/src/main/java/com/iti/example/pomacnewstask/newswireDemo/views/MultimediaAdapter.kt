package com.iti.example.pomacnewstask.newswireDemo.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iti.example.pomacnewstask.databinding.ListItemMultimediaDetailsBinding
import com.iti.example.pomacnewstask.pojos.Multimedia

class MultimediaAdapter :
    ListAdapter<Multimedia, MultimediaAdapter.MultimediaViewHolder>(MultimediaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MultimediaViewHolder.from(parent)

    override fun onBindViewHolder(holder: MultimediaViewHolder, position: Int) =
        holder.bind(getItem(position))

    class MultimediaViewHolder(val binding: ListItemMultimediaDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): MultimediaViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemMultimediaDetailsBinding.inflate(layoutInflater, parent, false)
                return MultimediaViewHolder(binding)
            }
        }

        fun bind(multimedia: Multimedia) {
            binding.multimedia = multimedia
            binding.executePendingBindings()
        }

    }

    class MultimediaDiffCallback : DiffUtil.ItemCallback<Multimedia>() {
        override fun areItemsTheSame(oldItem: Multimedia, newItem: Multimedia) =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: Multimedia, newItem: Multimedia) =
            oldItem == newItem
    }


}