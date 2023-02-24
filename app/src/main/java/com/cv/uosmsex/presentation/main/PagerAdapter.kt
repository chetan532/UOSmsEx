package com.cv.uosmsex.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class PagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val mFragmentList: MutableList<Fragment> = ArrayList()
    private val mFragmentTitleList: MutableList<String> = ArrayList()

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }
}