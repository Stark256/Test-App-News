package com.features.testapp_news.app.ui.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.features.testapp_news.R
import com.features.testapp_news.app.ui.customView.TopNewsListView
import kotlinx.android.synthetic.main.item_simple.view.*
import kotlinx.android.synthetic.main.item_top.view.*

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private val dataArr = ArrayList<BaseAdapterNews>()

    fun replaceAll(arr: ArrayList<BaseAdapterNews>) {
        dataArr.clear()
        if(arr.isNotEmpty()) {
            dataArr.addAll(arr)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        this.context = parent.context
        return when(viewType) {
            BaseAdapterNews.AdapterNewsType.TYPE_TOP.value -> TopNewsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_top, parent, false))
            BaseAdapterNews.AdapterNewsType.TYPE_SIMPLE.value -> SimpleNewsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_simple, parent, false))
            else -> SimpleNewsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_simple, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataArr[position].getType().value
    }

    override fun getItemCount(): Int {
        return dataArr.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataArr[position]
        when(item.getType()) {
            BaseAdapterNews.AdapterNewsType.TYPE_SIMPLE -> {
                (holder as SimpleNewsViewHolder).info.text = "LampaLampa.net"
                (holder as SimpleNewsViewHolder).time.text = (item as SimpleAdapterNews).news.time
                (holder as SimpleNewsViewHolder).title.text = (item as SimpleAdapterNews).news.title

            }
            BaseAdapterNews.AdapterNewsType.TYPE_TOP -> {
                (holder as TopNewsViewHolder).topNews.setTopNews((item as TopAdapterNews).arrTops)
            }
        }

    }

    class TopNewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val topNews: TopNewsListView = v.tnlv
    }

    class SimpleNewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val time: TextView = v.tv_simple_time
        val info: TextView = v.tv_simple_info
        val title: TextView = v.tv_simple_title
    }
}