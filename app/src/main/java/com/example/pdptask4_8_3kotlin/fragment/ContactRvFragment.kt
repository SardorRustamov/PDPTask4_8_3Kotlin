package com.example.pdptask4_8_3kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pdptask4_8_3kotlin.adapter.ContactAdapter
import com.example.pdptask4_8_3kotlin.databinding.FragmentContactRvBinding
import com.example.pdptask4_8_3kotlin.model.ContactList

class ContactRvFragment : Fragment() {

    var list:List<ContactList> = ArrayList<ContactList>()
    var fragmentListener: FirstFragmentListener? = null

    private var _binding : FragmentContactRvBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentContactRvBinding.inflate(inflater, container, false)
        val view = binding.root
        loadData()

        val adapter = ContactAdapter(list, object : ContactAdapter.OnItemClick {
            override fun onClickListener(contactList: ContactList?) {
                fragmentListener!!.onSendContact(contactList!!)
            }
        })
        binding.rv.adapter = adapter


        return view
    }


    private fun loadData() {

         list = ArrayList<ContactList>()

        for (i in 0..49) {
            (list as ArrayList<ContactList>).add(ContactList("Alisher", "+998 99 997 99 99"))
            (list as ArrayList<ContactList>).add(ContactList("Jasur", "+998 90 000 09 00"))
            (list as ArrayList<ContactList>).add(ContactList("Anvar", "+998 97 777 77 77"))
            (list as ArrayList<ContactList>).add(ContactList("Sanjar", "+998 95 500 00 07"))
            (list as ArrayList<ContactList>).add(ContactList("Jalol", "+998 97 700 00 00"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstFragmentListener) {
            fragmentListener = context as FirstFragmentListener
        } else {
            throw RuntimeException(context.toString() + "Error")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }


    interface FirstFragmentListener {
        fun onSendContact(contactList: ContactList)
    }
}
