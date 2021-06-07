package com.iti.example.pomacnewstask.pojos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    @SerializedName("slug_name")
    val slugName: String,
    val section: String,
    val title: String,
    val abstract: String,
    val url: String,
    val byline: String,
    @SerializedName("item_type")
    val itemType: String,
    val source: String,
    @SerializedName("published_date")
    val publishDate: String,
    val multimedia: List<Multimedia>

) : Parcelable

/*class NewsDeserializer : JsonDeserializer<List<News>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<News> {
        val news = json?.asJsonObject?.get("result")?.asJsonArray
        val newsList = mutableListOf<News>()
        newsList.
        return Gson().fromJson(news,News::class.java)
    }
}*/


//val newsList = mutableListOf<News>()
//news?.asJsonArray?.forEach {
//    val item = it.asJsonObject
//    item
//    newsList.add(
//        News(
//            item["slug_name"].asString,
//            item["section"].asString,
//            item["title"].asString,
//            item["abstract"].asString,
//            item["url"].asString,
//            item["byline"].asString,
//            item["item_type"].asString,
//            item["source"].asString,
//            item["published_date"].asString,
//            item["multimedia"].asJsonArray.as,
//
//            )
//    )
//}
//"slug_name":"06withinterest",
//"section":"Business",
//"subsection":"",
//"title":"The Week in Business: Jobs Are Up, Beef Is Down",
//"abstract":"The new jobs report was decent, but employers are still struggling to fill open positions.",
//"url":"https://www.nytimes.com/2021/06/06/business/the-week-in-business-jobs.html",
//"byline":"BY CHARLOTTE COWLES",
//"thumbnail_standard":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-thumbStandard.png",
//"item_type":"Article",
//"source":"New York Times",
//"updated_date":"2021-06-06T07:00:04-04:00",
//"created_date":"2021-06-06T07:00:04-04:00",
//"published_date":"2021-06-06T07:00:04-04:00",
//"first_published_date":"2021-06-06T07:00:04-04:00",
//"material_type_facet":"News",
//"kicker":"with interest",
//"subheadline":"",
//"des_facet":[
//"United States Economy",
//"Labor and Jobs",
//"Shutdowns (Institutional)",
//"Hiring and Promotion",
//"Unemployment"
//],
//"org_facet":null,
//"per_facet":null,
//"geo_facet":null,
//"related_urls":null,
//"multimedia":[
//{
//    "url":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-thumbStandard.png",
//    "format":"Standard Thumbnail",
//    "height":75,
//    "width":75,
//    "type":"image",
//    "subtype":"photo",
//    "caption":"",
//    "copyright":"Till Lauer"
//},
//{
//    "url":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-mediumThreeByTwo210.png",
//    "format":"mediumThreeByTwo210",
//    "height":140,
//    "width":210,
//    "type":"image",
//    "subtype":"photo",
//    "caption":"",
//    "copyright":"Till Lauer"
//},
//{
//    "url":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-mediumThreeByTwo440.png",
//    "format":"mediumThreeByTwo440",
//    "height":293,
//    "width":440,
//    "type":"image",
//    "subtype":"photo",
//    "caption":"",
//    "copyright":"Till Lauer"
//},
//{
//    "url":"https://static01.nyt.com/images/2021/06/05/business/05withinterest/05withinterest-articleInline.png",
//    "format":"Normal",
//    "height":131,
//    "width":190,
//    "type":"image",
//    "subtype":"photo",
//    "caption":"",
//    "copyright":"Till Lauer"
//}
//]
//},