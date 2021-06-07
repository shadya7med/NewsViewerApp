package com.iti.example.pomacnewstask.newswireList.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iti.example.pomacnewstask.databinding.ListItemNewsBinding
import com.iti.example.pomacnewstask.pojos.News

class NewsListAdapter(private val newsListClickListener: NewsListClickListener) :
    ListAdapter<News, NewsListAdapter.NewsListViewHolder>(NewsListDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsListViewHolder.from(parent)

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) =
        holder.bind(getItem(position),newsListClickListener)

    class NewsListViewHolder(private val binding: ListItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): NewsListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemNewsBinding.inflate(layoutInflater, parent, false)
                return NewsListViewHolder(binding)
            }
        }

        fun bind(currentNews: News, clickListener: NewsListClickListener) {
            binding.news = currentNews
            binding.newsClickListener = clickListener
            binding.executePendingBindings()
        }
    }

    class NewsListDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News) =
            oldItem.slugName == newItem.slugName

        override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem
    }

    class NewsListClickListener(val clickListener: (News) -> Unit) {
        fun onClick(news: News) = clickListener(news)
    }
}