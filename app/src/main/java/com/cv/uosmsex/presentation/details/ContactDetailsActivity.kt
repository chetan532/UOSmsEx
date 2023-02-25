package com.cv.uosmsex.presentation.details

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.cv.uosmsex.databinding.ActivityContactDetailsBinding
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.presentation.compose.ComposeActivity
import com.cv.uosmsex.utils.Constants.EXTRA_CONTACT_DETAILS
import dev.chrisbanes.insetter.applyInsetter

class ContactDetailsActivity : AppCompatActivity() {

    private var _binding: ActivityContactDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)
        supportActionBar.apply {
            this!!.setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbar.setNavigationOnClickListener(View.OnClickListener { finish() })

        binding.appBarLayout.applyInsetter {
            type(statusBars = true) {
                padding()
            }
        }

        val data = intent.getParcelableExtra<Contacts>(EXTRA_CONTACT_DETAILS)

        if (data != null) {

            binding.nameTxt.text = data.firstName + " " + data.lastName
            binding.profileImage.load(data.image)
            binding.numberTxt.text = data.phone
            binding.emailTxt.text = data.email

            binding.txtBtnSendMessage.setOnClickListener {
                val intent = Intent(this@ContactDetailsActivity, ComposeActivity::class.java)
                intent.putExtra(EXTRA_CONTACT_DETAILS, data)
                startActivity(intent)
            }
        }
    }
}