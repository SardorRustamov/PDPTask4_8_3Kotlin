package com.example.pdptask4_8_3kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pdptask4_8_3kotlin.databinding.FragmentContactViewBinding
import com.example.pdptask4_8_3kotlin.model.ContactList

class ContactViewFragment : Fragment() {

    private var _binding: FragmentContactViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateContactFragment(contactList: ContactList) {
        binding.name.text = contactList.name
        binding.phone.text = contactList.phone
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}