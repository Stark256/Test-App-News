package com.features.testapp_news.app.ui

import com.features.testapp_news.api.ApiService
import dagger.Module
import dagger.Provides

@Module
class MainViewModelModule {

    @Provides
    fun providesMainViewModelFactory(apiService: ApiService) : MainViewModelFactory {
        return MainViewModelFactory(apiService)
    }

}