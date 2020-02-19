package com.daou.menulayoutsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bottom_drawer.setOnClickListener(this)
        btn_drawer_layout.setOnClickListener(this)
        btn_viewpager.setOnClickListener(this)
        btn_bottom_appbar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_bottom_drawer -> startActivity(Intent(v.context, SecondActivity::class.java))
            R.id.btn_drawer_layout -> startActivity(Intent(v.context, ThirdActivity::class.java))
            R.id.btn_viewpager -> startActivity(Intent(v.context, FourthActivity::class.java))
            R.id.btn_bottom_appbar -> startActivity(Intent(v.context, FifthActivity::class.java))
        }
    }
}
