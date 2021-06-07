package com.iti.example.pomacnewstask

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.iti.example.pomacnewstask.constants.Keys
import com.iti.example.pomacnewstask.databinding.ActivityMainBinding
import com.iti.example.pomacnewstask.newswireDemo.views.NewsDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =  ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)
    }


    fun sendNews(){//news: News){
        //add other fragment dynamically
        val newsDetailsFragment = NewsDetailsFragment()//details_fragment_container
        supportFragmentManager.beginTransaction().add(R.id.details_fragment_container,newsDetailsFragment,
            Keys.DETAILS_FRAGMENT_TAG).commit()
        /*val newsBundle = bundleOf(Keys.NEWS_KEY to news)
        newsDetailsFragment.arguments = newsBundle*/
    }

}


