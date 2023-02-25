package com.cv.uosmsex.presentation.main.contacts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.cv.uosmsex.databinding.FragmentContactsBinding
import com.cv.uosmsex.model.Contacts
import com.cv.uosmsex.presentation.details.ContactDetailsActivity
import com.cv.uosmsex.presentation.main.MainViewModel
import com.cv.uosmsex.utils.Constants.EXTRA_CONTACT_DETAILS

class ContactsFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    lateinit var contactsAdapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentContactsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getContacts()

        mainViewModel.contactsLiveData.observe(
            viewLifecycleOwner,
            Observer {

                if (it != null && it.isNotEmpty()) {

                    contactsAdapter = ContactsAdapter(onItemClick = { position ->

                        onItemClick(it, position)
                    }, {
                    }).apply {
                        submitList(it)
                    }

                    binding.contactsRecycler.adapter = contactsAdapter
                }
            }
        )
    }

    private fun onItemClick(list: List<Contacts>, position: Int) {

        val intent = Intent(requireContext(), ContactDetailsActivity::class.java)
        intent.putExtra(EXTRA_CONTACT_DETAILS, list[position])
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}