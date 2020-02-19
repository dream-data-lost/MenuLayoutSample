package com.daou.menulayoutsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.daou.menulayoutsample.ui.chat.ChatFragment
import com.daou.menulayoutsample.ui.menu.MenuFragment
import com.daou.menulayoutsample.ui.notifications.NotificationsFragment
import com.daou.menulayoutsample.ui.org.OrgFragment
import com.daou.menulayoutsample.ui.today.TodayFragment

class SamplePageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val list: ArrayList<Fragment> = ArrayList()

    init {
        list.add(MenuFragment())
        list.add(TodayFragment())
        list.add(ChatFragment())
        list.add(OrgFragment())
        list.add(NotificationsFragment())
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}