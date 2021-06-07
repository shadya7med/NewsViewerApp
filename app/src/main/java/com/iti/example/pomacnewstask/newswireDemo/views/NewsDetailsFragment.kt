package com.iti.example.pomacnewstask.newswireDemo.views

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.iti.example.pomacnewstask.constants.Keys
import com.iti.example.pomacnewstask.databinding.FragmentNewsDetailsBinding
import com.iti.example.pomacnewstask.newswireDemo.viewmodel.NewsDetailsViewModel
import com.iti.example.pomacnewstask.pojos.News


class NewsDetailsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    var news:News? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            arguments?.let {
                if(it.getBoolean(Keys.IS_PREV_PORTRAIT)){
                   val navController = findNavController()
                    navController.previousBackStackEntry?.savedStateHandle?.set(Keys.SELECTED_NEWS, it.getParcelable(Keys.NEWS_KEY) as News?)
                    navController.navigateUp()
                }
            }
        }


        // Inflate the layout for this fragment
        val binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val newsDetailsViewModel = ViewModelProvider(this).get(NewsDetailsViewModel::class.java)
        binding.newsDetailsViewModel = newsDetailsViewModel



        binding.multimediaRvDetailsMain.adapter = MultimediaAdapter()

        val bundle = arguments
        bundle?.let {
            news = it.get(Keys.NEWS_KEY) as News?
        }

        news?.let {
            newsDetailsViewModel.setNewsDetails(it)
        }




        newsDetailsViewModel.openNewsOnWebData.observe(viewLifecycleOwner) {
            it?.let {
                val webpage: Uri = Uri.parse(it)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                if (intent.resolveActivity(requireActivity().packageManager) != null) {
                    startActivity(intent)
                    newsDetailsViewModel.onDoneOpeningNews()
                }
            }
        }




        return binding.root
    }


}