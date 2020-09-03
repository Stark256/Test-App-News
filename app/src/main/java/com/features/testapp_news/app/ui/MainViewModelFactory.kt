package com.features.testapp_news.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.features.testapp_news.api.ApiService
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val api: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(api) as T
    }
}