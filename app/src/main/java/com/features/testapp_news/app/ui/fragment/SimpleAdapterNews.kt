package com.features.testapp_news.app.ui.fragment

import com.features.testapp_news.api.NewsModel

class SimpleAdapterNews(val news: NewsModel) : BaseAdapterNews() {
    override fun getType(): AdapterNewsType = AdapterNewsType.TYPE_SIMPLE
}