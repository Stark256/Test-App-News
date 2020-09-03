package com.features.testapp_news.app.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.features.testapp_news.app.ui.fragment.FragmentFavourites
import com.features.testapp_news.app.ui.fragment.FragmentStories
import com.features.testapp_news.app.ui.fragment.FragmentVideo

class ViewPagerAdapter(val fm: FragmentManager, val tabCount: Int) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
//        return when(position) {
//            0 -> FragmentStories.newInstance(
//                FragmentStories.FragmentType.TYPE_STORIES)
//            1 -> FragmentStories.newInstance(
//                FragmentStories.FragmentType.TYPE_VIDEO)
//            else -> FragmentStories.newInstance(
//                FragmentStories.FragmentType.TYPE_FAVOURITES)
//        }

        return when(position) {
            0 -> FragmentStories()
            1 -> FragmentVideo()
            else -> FragmentFavourites()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}