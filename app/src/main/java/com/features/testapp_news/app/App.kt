package com.features.testapp_news.app

import android.app.Application
import com.features.testapp_news.R
import com.features.testapp_news.api.ApiModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//
        appComponent = DaggerAppComponent.builder()
            .apiModule(ApiModule(getString(R.string.base_url)))
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)

    }
}