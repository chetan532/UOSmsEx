package com.cv.uosmsex.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.cv.uosmsex.MainApplication
import com.cv.uosmsex.databinding.ActivityMainBinding
import com.cv.uosmsex.presentation.main.contacts.ContactsFragment
import com.cv.uosmsex.presentation.main.messages.MessagesFragment
import com.google.android.material.tabs.TabLayoutMediator
import dev.chrisbanes.insetter.applyInsetter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        (application as MainApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

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