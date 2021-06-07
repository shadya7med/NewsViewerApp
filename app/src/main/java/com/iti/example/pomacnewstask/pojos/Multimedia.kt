package com.iti.example.pomacnewstask.pojos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Multimedia(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int,
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String
) : Parcelable

/*class MultimediaDeserializer : JsonDeserializer<List<Multimedia>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<Multimedia> {
        val multimedia = json?.asJsonObject?.get("multimedia")
        val multiList = mutableListOf<Multimedia>()
        multimedia?.asJsonArray?.forEach {
            val item = it.asJsonObject
            multiList.add(
                Multimedia(
                    item["url"].asString,
                    item["format"].asString,
                    item["height"].asInt,
                    item["width"].asInt,
                    item["type"].asString,
                    item["subtype"].asString,
                    item["caption"].asString,
                    item["copyright"].asString
                )
            )
        }
        return multiList

    }
}*/

//"url":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-thumbStandard.png",
//    "format":"Standard Thumbnail",
//    "height":75,
//    "width":75,
//    "type":"image",
//    "subtype":"photo",
//    "caption":"",
//    "copyright":"Till Lauer"