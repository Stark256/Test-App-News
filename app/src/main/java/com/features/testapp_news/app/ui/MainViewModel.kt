package com.features.testapp_news.app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.features.testapp_news.api.ApiService
import com.features.testapp_news.api.NewsModel
import com.features.testapp_news.app.ui.base.NewsBaseModel
import com.features.testapp_news.app.ui.fragment.BaseAdapterNews
import com.features.testapp_news.app.ui.fragment.SimpleAdapterNews
import com.features.testapp_news.app.ui.fragment.TopAdapterNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val api: ApiService) : ViewModel() {

    val newsStories = MutableLiveData<ArrayList<BaseAdapterNews>>()
    val newsVideo = MutableLiveData<ArrayList<BaseAdapterNews>>()
    val newsFavourites = MutableLiveData<ArrayList<BaseAdapterNews>>()


    val stories: NewsBaseModel = NewsBaseModel(arrayListOf(), arrayListOf())
    val video: NewsBaseModel = NewsBaseModel(arrayListOf(), arrayListOf())
    val favourites: NewsBaseModel = NewsBaseModel(arrayListOf(), arrayListOf())

    fun getStories() {
        val resultArr = ArrayList<BaseAdapterNews>()
        if(stories.arrTopNews.isNotEmpty()) {
            resultArr.add(TopAdapterNews(stories.arrTopNews))
        }
        for(item in stories.arrNews) {
            resultArr.add(SimpleAdapterNews(item))
        }

        newsStories.value = resultArr
    }

    fun getVideo() {
        val resultArr = ArrayList<BaseAdapterNews>()
        if(video.arrTopNews.isNotEmpty()) {
            resultArr.add(TopAdapterNews(video.arrTopNews))
        }
        for(item in video.arrNews) {
            resultArr.add(SimpleAdapterNews(item))
        }

        newsVideo.value = resultArr
    }

    fun getFavourites()  {
        val resultArr = ArrayList<BaseAdapterNews>()
        if(favourites.arrTopNews.isNotEmpty()) {
            resultArr.add(TopAdapterNews(favourites.arrTopNews))
        }
        for(item in favourites.arrNews) {
            resultArr.add(SimpleAdapterNews(item))
        }

        newsFavourites.value = resultArr
    }

    fun loadNews() {

        api.getNews().enqueue(object : Callback<ArrayList<NewsModel>> {
            override fun onFailure(call: Call<ArrayList<NewsModel>>, t: Throwable) {
            t
            }

            override fun onResponse(
                call: Call<ArrayList<NewsModel>>,
                response: Response<ArrayList<NewsModel>>
            ) {
                response.body()?.let {resultArr ->

                    for(item in resultArr) {

                        when(item.type) {

                            "strories" -> {
                                if(item.top == 1)
                                    stories.arrTopNews.add(item)
                                else
                                    stories.arrNews.add(item)
                            }
                            "video" -> {
                                if(item.top == 1)
                                    video.arrTopNews.add(item)
                                else
                                    video.arrNews.add(item)
                            }
                            "favourites" -> {
                                if(item.top == 1)
                                    favourites.arrTopNews.add(item)
                                else
                                    favourites.arrNews.add(item)
                            }

                        }
                    }
                    getStories()
                    getVideo()
                    getFavourites()
                }
            }
        })

    }

}