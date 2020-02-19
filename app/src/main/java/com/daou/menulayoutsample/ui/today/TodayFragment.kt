package com.daou.menulayoutsample.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.daou.menulayoutsample.R

class TodayFragment : Fragment() {

    private lateinit var todayViewModel: TodayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        todayViewModel = ViewModelProvider(this).get(TodayViewModel::class.java)
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

}