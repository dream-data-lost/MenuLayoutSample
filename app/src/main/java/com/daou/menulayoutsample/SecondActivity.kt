package com.daou.menulayoutsample

import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.daou.menulayoutsample.ui.chat.ChatFragment
import com.daou.menulayoutsample.ui.menu.MenuFragment
import com.daou.menulayoutsample.ui.notifications.NotificationsFragment
import com.daou.menulayoutsample.ui.org.OrgFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_dialog.*

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar_second)
        val navView: BottomNavigationView = findViewById(R.id.second_nav_view)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_menu, R.id.navigation_today, R.id.navigation_chat, R.id.navigation_org, R.id.navigation_notifications
            )
        )

        val sheetBehavior = BottomSheetBehavior.from(rl_bottom_sheet)

        val navigationChangeListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.navigation_menu -> {
                    if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    } else {
                        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                    return@OnNavigationItemSelectedListener false
                }
                R.id.navigation_today -> {
                    transaction.replace(R.id.nav_host_fragment, MenuFragment()).commitAllowingStateLoss()
                }
                R.id.navigation_chat -> {
                    transaction.replace(R.id.nav_host_fragment, ChatFragment()).commitAllowingStateLoss()
                }
                R.id.navigation_org -> {
                    transaction.replace(R.id.nav_host_fragment, OrgFragment()).commitAllowingStateLoss()
                }
                R.id.navigation_notifications -> {
                    transaction.replace(R.id.nav_host_fragment, NotificationsFragment()).commitAllowingStateLoss()
                }
            }
            true
        }
        navView.setOnNavigationItemSelectedListener(navigationChangeListener)
        navView.selectedItemId = R.id.navigation_today
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.third, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
