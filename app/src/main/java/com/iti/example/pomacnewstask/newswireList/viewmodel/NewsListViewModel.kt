package com.iti.example.pomacnewstask.newswireList.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iti.example.pomacnewstask.model.NewsWireApi
import com.iti.example.pomacnewstask.pojos.News
import kotlinx.coroutines.launch


class NewsListViewModel : ViewModel() {

    private val _newsList = MutableLiveData<List<News>?>()
    val newsList:LiveData<List<News>?>
        get() = _newsList

    private val _errorMsg = MutableLiveData<String?>()
    val errorMsg:LiveData<String?>
        get() = _errorMsg


    private val _onNavigateToNewsDetailsData = MutableLiveData<News?>()
    val onNavigateToNewsDetailsData:LiveData<News?>
        get() = _onNavigateToNewsDetailsData


    init{
        getAllNews()
    }

    private fun getAllNews(){
        viewModelScope.launch {
            try {
                _newsList.value = NewsWireApi.getAllNews().results
                Log.i("NewsVM", "${_newsList.value?.size}")
            }catch (e:Exception){
                _errorMsg.value = e.localizedMessage
            }

        }
    }

    fun onNavigateToNewsDetails(news:News){
        _onNavigateToNewsDetailsData.value = news
    }
    fun onDoneNavigationToNewsDetails(){
        _onNavigateToNewsDetailsData.value = null
    }
}