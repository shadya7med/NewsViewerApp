package com.iti.example.pomacnewstask.model

import com.iti.example.pomacnewstask.pojos.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.nytimes.com/svc/news/v3/content/all/all.json?api-key=vXGYGM5YxuRaHhceWD6v9qI1zwY5PQyh
interface NewsApiService {

    @GET("all.json")
    suspend fun getAllTrips(@Query("api-key")apiKey:String):Response
}