
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
import kotlinx.android.synthetic.main.fragment_stories.*
import kotlinx.android.synthetic.main.fragment_video.*

class FragmentVideo : Fragment() {

//    companion object {
//
//        val ARG_TYPE = "arg_type"
//
//        fun newInstance(type: FragmentType) : FragmentStories {
//            return FragmentStories().apply {
//                arguments = Bundle().apply {
//                    putSerializable(ARG_TYPE, type)
//                }
//            }
//        }
//
//    }

    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        this.adapter = NewsAdapter()
        rv_video.adapter = adapter
        rv_video.layoutManager = LinearLayoutManager(context)

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
                        mainActivity.viewModel.newsVideo.observe(mainActivity, Observer<ArrayList<BaseAdapterNews>> {
                            adapter.replaceAll(it)
                        })
//                        adapter.replaceAll(mainActivity.viewModel.getVideo())
                        mainActivity.viewModel.getVideo()
//                    }
//                    FragmentType.TYPE_FAVOURITES -> {
//                        mainActivity.viewModel.newsFavourites.observe(mainActivity, Observer<ArrayList<BaseAdapterNews>> {
//                            adapter.replaceAll(it)
//                        })
//                        adapter.replaceAll(mainActivity.viewModel.getFavourites())
//                    }
//                }
//            }

        }

    }

    enum class FragmentType {
        TYPE_STORIES, TYPE_VIDEO, TYPE_FAVOURITES
    }

}

