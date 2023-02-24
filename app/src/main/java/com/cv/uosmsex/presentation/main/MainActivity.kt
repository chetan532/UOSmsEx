package com.cv.uosmsex.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.cv.uosmsex.databinding.ActivityMainBinding
import com.cv.uosmsex.presentation.main.contacts.ContactsFragment
import com.cv.uosmsex.presentation.main.messages.MessagesFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.applyInsetter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.appBarLayout.applyInsetter {
            type(statusBars = true) {
                padding()
            }
        }

        val adapter = PagerAdapter(this)
        adapter.addFragment(ContactsFragment(), "Contacts")
        adapter.addFragment(MessagesFragment(), "Messages")

        binding.dataPager.adapter = adapter
        binding.dataPager.currentItem = 0
        TabLayoutMediator(binding.mainHomeTabs, binding.dataPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}