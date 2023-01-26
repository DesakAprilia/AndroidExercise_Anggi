@file:Suppress("DEPRECATION")

package com.kampusmerdeka.tablayout.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kampusmerdeka.tablayout.Fragments.HomeFragment
import com.kampusmerdeka.tablayout.Fragments.ProfileFragment
import com.kampusmerdeka.tablayout.Fragments.SettingsFragment

internal class MyAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int ): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                HomeFragment()
            }

            1 -> {
                ProfileFragment()
            }

            2 -> {
                SettingsFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}