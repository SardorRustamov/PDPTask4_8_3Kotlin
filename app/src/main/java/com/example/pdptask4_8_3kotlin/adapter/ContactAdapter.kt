package com.example.pdptask4_8_3kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdptask4_8_3kotlin.databinding.ItemContactBinding
import com.example.pdptask4_8_3kotlin.model.ContactList


class ContactAdapter( val contactList: List<ContactList>, var onItemClick: OnItemClick) : RecyclerView.Adapter<ContactAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.name.setText(contactList[position].name)
        holder.binding.phone.setText(contactList[position].phone)
        holder.itemView.setOnClickListener { view: View? ->
            onItemClick.onClickListener(
                contactList[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class VH(var binding: ItemContactBinding) : RecyclerView.ViewHolder(
        binding.root
    )

    interface OnItemClick {
        fun onClickListener(contactList: ContactList?)
    }
}
