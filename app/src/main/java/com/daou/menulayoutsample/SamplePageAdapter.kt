package com.daou.menulayoutsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.daou.menulayoutsample.ui.gallery.GalleryFragment
import com.daou.menulayoutsample.ui.home.HomeFragment
import com.daou.menulayoutsample.ui.notifications.NotificationsFragment

class SamplePageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val list: ArrayList<Fragment> = ArrayList()

    init {
        list.add(HomeFragment())
        list.add(GalleryFragment())
        list.add(NotificationsFragment())
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}