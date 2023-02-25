package com.cv.uosmsex.presentation.main.messages

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.cv.uosmsex.databinding.FragmentMessagesBinding
import com.cv.uosmsex.presentation.main.MainViewModel
import com.cv.uosmsex.utils.gone
import com.cv.uosmsex.utils.visible

class MessagesFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    lateinit var messagesAdapter: MessagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMessagesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getMessages()

        mainViewModel.messages.observe(
            viewLifecycleOwner,
            Observer {

                if (it.isNotEmpty()) {

                    messagesAdapter = MessagesAdapter(onItemClick = { position ->

//                        onItemClick(it, position)
                    }, {
                    }).apply {
                        submitList(it)
                    }

                    binding.messagesRecycler.adapter = messagesAdapter

                    binding.messagesRecycler.visible()
                    binding.noHistoryLinear.gone()
                    Log.e("TAG", "onViewCreated: ISNOTEMPTY ===> " + it.size)
                } else {
                    binding.messagesRecycler.gone()
                    binding.noHistoryLinear.visible()
                    Log.e("TAG", "onViewCreated: ISEMPTY ")
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}