package com.example.phonebook.data

import com.example.phonebook.R
import com.example.phonebook.data.model.Entry

class Datasource {

    fun getEntryList(): MutableList<Entry> {
        return mutableListOf(
            Entry("Fritz", "491582", R.drawable.entry_acc_image),
            Entry("Onkel Roger","422588",R.drawable.entry_acc_image),
            Entry("Kim Jong","23482",R.drawable.entry_acc_image),
            Entry("Kim Chi","342873",R.drawable.entry_acc_image),
            Entry("Popeye","98829",R.drawable.entry_acc_image),
            Entry("Willhelm","59822",R.drawable.entry_acc_image)
        )
    }
}