package com.iti.example.pomacnewstask.model

import com.iti.example.pomacnewstask.constants.Keys
import com.iti.example.pomacnewstask.constants.URLs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsWireApi {

    /*private val gson = GsonBuilder()
        .registerTypeAdapter(News::class.java, NewsDeserializer())
        .registerTypeAdapter(Multimedia::class.java, MultimediaDeserializer())
        .create()*/

    private val retrofit =
        Retrofit.Builder()
            //.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URLs.NEWS_WIRE_BASE_URL)
            .build()

    private val newsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

    suspend fun getAllNews() = newsApiService.getAllTrips(Keys.NEW_WIRE_API_KEY)
}