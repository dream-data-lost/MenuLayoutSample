package com.daou.menulayoutsample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.daou.menulayoutsample.ui.BottomNavigationDrawerFragment
import com.daou.menulayoutsample.ui.chat.ChatFragment
import com.daou.menulayoutsample.ui.notifications.NotificationsFragment
import com.daou.menulayoutsample.ui.org.OrgFragment
import com.daou.menulayoutsample.ui.today.TodayFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_fifth.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class FifthActivity: AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        setSupportActionBar(bottom_appbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        when(item.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
            R.id.navigation_today -> {
                bottom_appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                transaction.replace(R.id.nav_host_fragment, TodayFragment()).commitAllowingStateLoss()
            }
            R.id.navigation_chat -> {
                bottom_appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                transaction.replace(R.id.nav_host_fragment, ChatFragment()).commitAllowingStateLoss()
            }
            R.id.navigation_org -> {
                bottom_appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                transaction.replace(R.id.nav_host_fragment, OrgFragment()).commitAllowingStateLoss()
            }
            R.id.navigation_notifications -> {
                bottom_appbar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                transaction.replace(R.id.nav_host_fragment, NotificationsFragment()).commitAllowingStateLoss()
            }
        }
        return true
    }
}