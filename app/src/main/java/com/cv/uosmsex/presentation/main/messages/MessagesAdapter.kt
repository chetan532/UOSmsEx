package com.cv.uosmsex.presentation.main.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cv.uosmsex.databinding.ItemMessagesBinding
import com.cv.uosmsex.model.Message

class MessagesAdapter(
    val onItemClick: (position: Int) -> Unit,
    val onBindComplete: (position: Int) -> Unit
) :
    ListAdapter<Message, RecyclerView.ViewHolder>(DiffCallback) {

    inner class HomeGridViewHolder(private val binding: ItemMessagesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(nasaData: Message, position: Int) {
            binding.nameTxt.text = nasaData.firstName + " " + nasaData.lastName
            binding.profileImage.load(nasaData.image)
            binding.numberTxt.text = nasaData.phone
            binding.yourOTPTxt.text = nasaData.text
            binding.yourOTPTime.text = nasaData.date
            binding.root.setOnClickListener {
                onItemClick(position)
            }
            onBindComplete(position)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemMessagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val adjustViewHolder = holder as HomeGridViewHolder
        val cast = getItem(position)

        cast.let {
            adjustViewHolder.onBind(it, position)
        }
    }
}