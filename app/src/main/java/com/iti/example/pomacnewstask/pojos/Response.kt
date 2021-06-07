package com.iti.example.pomacnewstask.pojos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    val status:String,
    val copyright:String,
    @SerializedName("num_results")
    val numResults:Int,
    val results:List<News>
):Parcelable

//"status":"OK",
//"copyright":"Copyright (c) 2021 The New York Times Company.  All Rights Reserved.",
//"num_results":500,
//"results":[]
