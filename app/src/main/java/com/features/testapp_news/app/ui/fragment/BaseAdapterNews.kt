package com.features.testapp_news.app.ui.fragment

abstract class BaseAdapterNews {

    enum class AdapterNewsType(var value: Int) {
        TYPE_TOP(0), TYPE_SIMPLE(1)
    }

    abstract fun getType() : BaseAdapterNews.AdapterNewsType
}