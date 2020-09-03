package com.features.testapp_news.app.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.features.testapp_news.app.App
import com.features.testapp_news.app.AppComponent

open class BaseActivity : AppCompatActivity() {

    val appComponent: AppComponent
        get() { return (application as App).appComponent }
}