package com.iti.example.pomacnewstask.newswireList.views

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.iti.example.pomacnewstask.R
import com.iti.example.pomacnewstask.constants.Keys
import com.iti.example.pomacnewstask.databinding.FragmentNewsListBinding
import com.iti.example.pomacnewstask.newswireList.viewmodel.NewsListViewModel
import com.iti.example.pomacnewstask.pojos.News


class NewsListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentNewsListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        val newsListViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        binding.newsListViewModel = newsListViewModel



        binding.newsListRvMain.adapter = NewsListAdapter(NewsListAdapter.NewsListClickListener {
            newsListViewModel.onNavigateToNewsDetails(it)
        })
        newsListViewModel.errorMsg.observe(viewLifecycleOwner) {
            it?.let {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "there's no connection ",
                    Snackbar.LENGTH_LONG
                ).show()
                Log.e("NewsListFragment", it )
            }

        }
        val navController = findNavController()
        newsListViewModel.onNavigateToNewsDetailsData.observe(viewLifecycleOwner) {
            it?.let {
                val newsBundle = bundleOf(Keys.NEWS_KEY to it)
                val orientation = resources.configuration.orientation
                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    newsBundle.putBoolean(Keys.IS_PREV_PORTRAIT, true)

                    navController.navigate(
                        R.id.action_newsListFragment_to_newsDetailsFragment,
                        newsBundle
                    )

                } else {
                    //onNavigateToDetailsLand(newsBundle)
                    navController.currentBackStackEntry?.savedStateHandle?.set(Keys.SELECTED_NEWS, it as News?)


                }
                newsListViewModel.onDoneNavigationToNewsDetails()
            }
        }
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<News>(Keys.SELECTED_NEWS)
            ?.observe(
                viewLifecycleOwner
            ) {
                it?.let {
                    val newsBundle = bundleOf(Keys.NEWS_KEY to it)
                    onNavigateToDetailsLand(newsBundle)
                    newsListViewModel.onDoneNavigationToNewsDetails()
                }

            }




        return binding.root
    }

    private fun onNavigateToDetailsLand(newsBundle: Bundle) {
        val detailsNavHostFragment =
            childFragmentManager.findFragmentById(R.id.details_fragment_container) as NavHostFragment
        val detailsNavController = detailsNavHostFragment.findNavController()
        newsBundle.putBoolean(Keys.IS_PREV_PORTRAIT, false)
        detailsNavController.navigate(R.id.newsDetailsFragment, newsBundle)
    }

}