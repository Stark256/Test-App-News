package com.features.testapp_news.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.features.testapp_news.R
import com.features.testapp_news.app.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_stories.*

class FragmentFavourites : Fragment() {

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        this.adapter = NewsAdapter()
        rv_favourites.adapter = adapter
        rv_favourites.layoutManager = LinearLayoutManager(context)

        (activity as? MainActivity)?.let { mainActivity ->

//            arguments!!.get(ARG_TYPE)?.let {
//                when (it) {
//                    FragmentType.TYPE_STORIES -> {
//                        mainActivity.viewModel.newsStories.observe(mainActivity, Observer<ArrayList<BaseAdapterNews>> {
//                            adapter.replaceAll(it)
//                        })
//                        adapter.replaceAll(mainActivity.viewModel.getStories())
//                    }
//                    FragmentType.TYPE_VIDEO -> {
//                        mainActivity.viewModel.newsVideo.observe(mainActivity, Observer<ArrayList<BaseAdapterNews>> {
//                            adapter.replaceAll(it)
//                        })
//                        adapter.replaceAll(mainActivity.viewModel.getVideo())
//                    }
//                    FragmentType.TYPE_FAVOURITES -> {
                        mainActivity.viewModel.newsFavourites.observe(mainActivity, Observer<ArrayList<BaseAdapterNews>> {
                            adapter.replaceAll(it)
                        })
//                        adapter.replaceAll(mainActivity.viewModel.getFavourites())
                        mainActivity.viewModel.getFavourites()
//                    }
//                }
//            }

        }

    }

    enum class FragmentType {
        TYPE_STORIES, TYPE_VIDEO, TYPE_FAVOURITES
    }

}

