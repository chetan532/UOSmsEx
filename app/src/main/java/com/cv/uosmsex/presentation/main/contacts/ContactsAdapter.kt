package com.cv.uosmsex.presentation.main.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cv.uosmsex.databinding.ItemContactsBinding
import com.cv.uosmsex.model.Contacts

class ContactsAdapter(
    val onItemClick: (position: Int) -> Unit,
    val onBindComplete: (position: Int) -> Unit
) :
    ListAdapter<Contacts, RecyclerView.ViewHolder>(DiffCallback) {

    inner class HomeGridViewHolder(private val binding: ItemContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(nasaData: Contacts, position: Int) {
            binding.nameTxt.text = nasaData.firstName + " " + nasaData.lastName
            binding.numberTxt.text = nasaData.phone
            binding.root.setOnClickListener {
                onItemClick(position)
            }
            onBindComplete(position)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Contacts>() {
        override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem.phone == newItem.phone
        }

        override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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