package com.daou.menulayoutsample

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.activity_third.view.*
import kotlinx.android.synthetic.main.app_bar_third.*
import kotlinx.android.synthetic.main.content_third.*

class ThirdActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_mail, R.id.nav_contacts, R.id.nav_works,
                R.id.nav_board, R.id.nav_calendar, R.id.nav_community,
                R.id.nav_reserve, R.id.nav_approval, R.id.nav_report,
                R.id.nav_task, R.id.nav_survey, R.id.nav_todo,
                R.id.nav_attendance, R.id.nav_docs
            ), drawer_layout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        third_bottom_nav_view.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open,  R.string.close)
        toggle.setToolbarNavigationClickListener {
            it.drawer_layout.openDrawer(GravityCompat.START)
        }
        toggle.syncState()
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
