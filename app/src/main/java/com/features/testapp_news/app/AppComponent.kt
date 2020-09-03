package com.features.testapp_news.app

import android.app.Application
import com.features.testapp_news.api.ApiModule
import com.features.testapp_news.api.ApiService
import com.features.testapp_news.app.ui.MainActivity
import com.features.testapp_news.app.ui.MainViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AppModule::class,
    ApiModule::class,
    MainViewModelModule::class
))
interface AppComponent {

    fun application() : Application
    fun apiService() : ApiService

    fun inject(app: Application)
    fun inject(mainActivity: MainActivity)
}