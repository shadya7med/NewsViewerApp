package com.iti.example.pomacnewstask

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iti.example.pomacnewstask.newswireDemo.views.MultimediaAdapter
import com.iti.example.pomacnewstask.newswireList.views.NewsListAdapter
import com.iti.example.pomacnewstask.pojos.Multimedia
import com.iti.example.pomacnewstask.pojos.News

@BindingAdapter("listAllNews")
fun RecyclerView.setListAllNews(list: List<News>?) {
    (this.adapter as NewsListAdapter).submitList(list)
}

@BindingAdapter("newsImage")
fun ImageView.setNewsImage(multimedia: List<Multimedia>?) {
    if (!multimedia.isNullOrEmpty()) {
        Glide
            .with(this.context)
            .load(multimedia[2].url)
            .centerCrop()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_broken_image)
    }
}

@BindingAdapter("multimediaImage")
fun ImageView.setMultimediaImage(multimedia: Multimedia?) {
    multimedia?.let {
        if (it.url.isNotEmpty()) {
            Glide
                .with(this.context)
                .load(multimedia.url)
                .centerCrop()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(this)
        }
    }

}

@BindingAdapter("listMultimedia")
fun RecyclerView.setListMultimedia(list: List<Multimedia>?) {
    (this.adapter as MultimediaAdapter).submitList(list)
}

@BindingAdapter("publishingDateText")
fun TextView.setPublishingDateText(date: String?) {
    date?.let { date ->
        val dateList = date.split("T")
        val dayDate = dateList[0]
        val hourDate = dateList[1].substring(0, 5)
        val dateText = dayDate + " " + hourDate
        text = dateText
    }


}

@BindingAdapter("visibilityAgainstData")
fun View.setVisibilityAgainstData(news: News?) {
    visibility = if (news != null) {
        View.VISIBLE
    } else {
        View.GONE
    }

}
@BindingAdapter("rvVisibilityAgainstLoading")
fun RecyclerView.setVisibilityAgainstLoading(loadingStatus:Int?){
    loadingStatus?.let {
        visibility = when(it){
            View.VISIBLE->View.GONE
            else->View.VISIBLE
        }
    }
}