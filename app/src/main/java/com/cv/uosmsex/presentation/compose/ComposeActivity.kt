package com.cv.uosmsex.presentation.compose

import android.R
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cv.uosmsex.MainApplication
import com.cv.uosmsex.databinding.ActivityComposeBinding
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.model.Message
import com.cv.uosmsex.retrofit.Result
import com.cv.uosmsex.utils.Constants
import com.cv.uosmsex.utils.Loader
import com.cv.uosmsex.utils.getRandomNumber
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class ComposeActivity : AppCompatActivity() {

    private var _binding: ActivityComposeBinding? = null
    private val binding get() = _binding!!

    lateinit var composeViewModel: ComposeViewModel

    @Inject
    lateinit var composeViewModelFactory: ComposeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityComposeBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        (application as MainApplication).applicationComponent.injectCompose(this)
        composeViewModel =
            ViewModelProvider(this, composeViewModelFactory)[ComposeViewModel::class.java]

        binding.mainBackButton.setOnClickListener {
            finish()
        }

        val data = intent.getParcelableExtra<Contacts>(Constants.EXTRA_CONTACT_DETAILS)

        if (data != null) {

            binding.phoneNumber.setText(data.phone.toString())

            val selectedRandomNumber = getRandomNumber()
            binding.otpDetails.text = "Hi. Your OTP is $selectedRandomNumber"

            binding.btnSend.setOnClickListener {

                var currentDateTime = ""
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

                    currentDateTime = LocalDateTime.now().format(formatter)
                }

                composeViewModel.sendOTP(
                    data.phone.replace(" ", ""),
                    selectedRandomNumber.toString()
                )

                val loader = Loader(this, R.style.Theme_Translucent_NoTitleBar)
                composeViewModel.sendResponse.observe(
                    this,
                    Observer {

                        when (it) {
                            is Result.Success -> {
                                loader.cancel()
                                val message = Message(
                                    text = binding.otpDetails.text.toString(),
                                    firstName = data.firstName,
                                    lastName = data.lastName,
                                    email = data.email,
                                    date = currentDateTime,
                                    image = data.image,
                                    otp = selectedRandomNumber.toString(),
                                    phone = data.phone
                                )
                                composeViewModel.addMessage(message)

                                Constants.otpSendSuccessDialog(this)
                            }
                            is Result.Error -> {
                                loader.cancel()
                            }
                            is Result.Loading -> {

                                loader.show()
                                loader.setCancelable(false)
                                loader.setCanceledOnTouchOutside(false)
                            }
                        }
                    }
                )
            }
        }
    }
}