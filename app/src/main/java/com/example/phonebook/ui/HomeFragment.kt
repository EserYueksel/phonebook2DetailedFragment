package com.example.phonebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appName.adapter.EntryAdapter
import com.example.phonebook.R
import com.example.phonebook.data.Datasource
import com.example.phonebook.data.model.Entry
import com.example.phonebook.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val datasource = Datasource()
        val entryList = datasource.getEntryList()
        // im Fragment bekommt man den Context nicht wie von der Activity gewohnt über this.
        // sondern über requireContext()
        binding.homePhonebookRecycler.adapter = EntryAdapter(requireContext(),entryList)
        val deleteEntry = { abc: Entry ->
            deleteEntryItem(entryList, abc)
        }

        binding.homeAddEntryButton.setOnClickListener {
            val name = binding.homeInputNameText.text.toString()
            val number = binding.homeInputNumberText.text.toString()

            if(!name.isNullOrEmpty() && !number.isNullOrEmpty()){
                val newEntry = Entry(name, number, R.drawable.entry_acc_image)
                entryList.add(newEntry)

                binding.homeInputNameText.text = null
                binding.homeInputNumberText.text = null
            }
        }

    }
    fun deleteEntryItem(entryList: MutableList<Entry>, entry: Entry){
        entryList.remove(entry)
    }
}