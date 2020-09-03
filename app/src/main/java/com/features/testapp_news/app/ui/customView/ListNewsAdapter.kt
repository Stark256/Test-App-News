package com.features.testapp_news.app.ui.customView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.features.testapp_news.R
import com.features.testapp_news.api.NewsModel
import kotlinx.android.synthetic.main.item_swipe_top.view.*


class ListNewsAdapter : PagerAdapter() {

    private val arrNews: ArrayList<NewsModel> = ArrayList()

    fun replaceAll(arr: ArrayList<NewsModel>) {
        arrNews.clear()
        if(arr.isNotEmpty()) {
            arrNews.addAll(arr)
        }
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return arrNews.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = arrNews[position]
        val v = LayoutInflater.from(container.context).inflate(R.layout.item_swipe_top, container, false)

        item.img?.let {

            Glide.with(container.context)
                .load(item.img)
                .centerCrop()
                .into(v.iv_top_image)
        }

        v.tv_top_time.text = "- ${item.time}"
        v.tv_top_info.text = "LampaLampa.net"
        v.tv_top_title.text = item.title

        container.addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}