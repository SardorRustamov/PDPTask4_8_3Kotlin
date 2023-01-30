package com.example.pdptask4_8_3kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pdptask4_8_3kotlin.fragment.ContactRvFragment
import com.example.pdptask4_8_3kotlin.fragment.ContactViewFragment
import com.example.pdptask4_8_3kotlin.model.ContactList

class MainActivity : AppCompatActivity(), ContactRvFragment.FirstFragmentListener{

    private lateinit var contactRvFragment: ContactRvFragment
    private lateinit var contactViewFragment: ContactViewFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        contactRvFragment = ContactRvFragment()
        contactViewFragment = ContactViewFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_first, contactRvFragment!!)
            .replace(R.id.frame_second, contactViewFragment)
            .commit()
    }

    override fun onSendContact(contactList: ContactList) {
        contactViewFragment.updateContactFragment(contactList)
    }


}