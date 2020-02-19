package com.daou.menulayoutsample.ui.org

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daou.menulayoutsample.R

class OrgFragment : Fragment() {

    private lateinit var orgViewModel: OrgViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orgViewModel =
            ViewModelProviders.of(this).get(OrgViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_org, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        orgViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}