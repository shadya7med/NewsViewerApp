package com.iti.example.pomacnewstask.newswireDemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iti.example.pomacnewstask.pojos.Multimedia
import com.iti.example.pomacnewstask.pojos.News

class NewsDetailsViewModel : ViewModel() {

    private val _newsDetails = MutableLiveData<News?>()
    val newsDetails: LiveData<News?>
        get() = _newsDetails

    private val _multimediaList = MutableLiveData<List<Multimedia>?>()
    val multimediaList: LiveData<List<Multimedia>?>
        get() = _multimediaList

    private val _openNewsOnWebData = MutableLiveData<String?>()
    val openNewsOnWebData:LiveData<String?>
        get() = _openNewsOnWebData

    fun setNewsDetails(news: News){
        _newsDetails.value = news
        _multimediaList.value = news.multimedia
    }


    fun openNewsOnWeb(news: News){
        _openNewsOnWebData.value = news.url
    }
    fun onDoneOpeningNews(){
        _openNewsOnWebData.value = null
    }

}