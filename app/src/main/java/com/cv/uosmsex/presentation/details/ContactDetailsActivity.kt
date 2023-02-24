package com.cv.uosmsex.presentation.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cv.uosmsex.R
import com.cv.uosmsex.databinding.ActivityContactDetailsBinding
import com.cv.uosmsex.databinding.ActivityMainBinding
import dev.chrisbanes.insetter.applyInsetter

class ContactDetailsActivity : AppCompatActivity() {

    private var _binding: ActivityContactDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.appBarLayout.applyInsetter {
            type(statusBars = true) {
                padding()
            }
        }


    }
}