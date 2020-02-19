package com.daou.menulayoutsample

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_fourth.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_dialog.*

class FourthActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        setSupportActionBar(toolbar_fourth)

        val pageAdapter = SamplePageAdapter(supportFragmentManager)
        nav_viewpager.adapter = pageAdapter

        nav_viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                fourth_nav_view.menu.getItem(position).isChecked = true
            }
        })
        val sheetBehavior = BottomSheetBehavior.from(rl_bottom_sheet)

        val navigationChangeListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_menu -> {
                    if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    } else {
                        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                    return@OnNavigationItemSelectedListener false
                }
                R.id.navigation_today -> {
                    nav_viewpager.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_chat -> {
                    nav_viewpager.currentItem = 2
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_org -> {
                    nav_viewpager.currentItem = 3
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    nav_viewpager.currentItem = 4
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        fourth_nav_view.setOnNavigationItemSelectedListener(navigationChangeListener)
        fourth_nav_view.selectedItemId = R.id.navigation_today
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.third, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_viewpager)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}