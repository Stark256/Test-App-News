package com.features.testapp_news.app.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.features.testapp_news.R
import com.features.testapp_news.api.NewsModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.view_news_list.view.*

class TopNewsListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0): RelativeLayout(context, attrs, defStyleAttr){


    private var rootView: RelativeLayout? = null
    private var listTabLayout: TabLayout? = null
    private var listViewPager: ViewPager? = null
    private lateinit var listAdapter : ListNewsAdapter

    init {
        val v = LayoutInflater.from(context).inflate(R.layout.view_news_list, this, true)

        this.rootView = v.rl_root
        this.listTabLayout = v.listTabLayout
        this.listViewPager = v.listViewPager

        this.listAdapter = ListNewsAdapter()
        this.listViewPager!!.adapter = this.listAdapter
        this.listTabLayout!!.setupWithViewPager(this.listViewPager)
    }


    fun setTopNews(arr: ArrayList<NewsModel>) {
        this.listAdapter.replaceAll(arr)
    }
}