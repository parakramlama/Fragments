package com.parakram.fragment

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.parakram.fragment.adapter.ViewPagerAdapter
import com.parakram.fragment.fragments.AreaFragment
import com.parakram.fragment.fragments.SumFragment

class TabLayout : AppCompatActivity() {
    private lateinit var lstTitle: Array<String>
    private lateinit var lstFragments: Array<Fragment>
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        populateList()
        val adapter = ViewPagerAdapter(lstFragments, supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager) {tab, position->
            tab.text = lstTitle[position]
        }.attach()
    }


    private fun populateList() {
        lstTitle = Array<String>()
        lstTitle.add("Sum")
        lstTitle.add("Area of circle")
        lstFragments = Array<Fragment>()
        lstFragments.add(SumFragment())
        lstFragments.add(AreaFragment())
    }
}