package com.iti.example.pomacnewstask.newswireList.viewmodel

import android.util.Log
import android.view.View
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

    private val _loadingStatus = MutableLiveData<Int?>()
    val loadingStatus:LiveData<Int?>
        get() = _loadingStatus

    private val _errorStatus = MutableLiveData<Int?>()
    val errorStatus:LiveData<Int?>
        get() = _errorStatus

    private val _onNavigateToNewsDetailsData = MutableLiveData<News?>()
    val onNavigateToNewsDetailsData:LiveData<News?>
        get() = _onNavigateToNewsDetailsData


    init{
        _loadingStatus.value = View.GONE
        _errorStatus.value = View.GONE
        getAllNews()
    }

    private fun getAllNews(){
        _loadingStatus.value = View.VISIBLE
        viewModelScope.launch {
            try {
                _newsList.value = NewsWireApi.getAllNews().results
                _loadingStatus.value = View.GONE
                _errorStatus.value = View.GONE
                Log.i("NewsVM", "${_newsList.value?.size}")
            }catch (e:Exception){
                _errorMsg.value = e.localizedMessage
                _errorStatus.value = View.VISIBLE
                _loadingStatus.value = View.GONE
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