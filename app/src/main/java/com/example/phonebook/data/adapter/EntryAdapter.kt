package com.example.appName.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.data.model.Entry
import com.example.phonebook.ui.HomeFragmentDirections
import com.google.android.material.card.MaterialCardView


class EntryAdapter(private val context: Context, private val dataset: MutableList<Entry>)
    : RecyclerView.Adapter<EntryAdapter.ViewHolder>() {

    // define those parts of the layout that shall be renewed before displaying
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var entryName = view.findViewById<TextView>(R.id.entry_name_text)
        var entryNumber = view.findViewById<TextView>(R.id.entry_number_text)
        val entryImage = view.findViewById<ImageView>(R.id.entry_image)
        val deleteEntry = view.findViewById<ImageView>(R.id.entry_delete)
    //  val editEntry = view.findViewById<ImageView>(R.id.entry_edit)
        val entryCard = view.findViewById<CardView>(R.id.entry_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.entry_item, parent, false)
        return ViewHolder(adapterLayout)
    }

    // recycling process starts
    // the attributes of the ViewHolder are renewed
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = dataset[position]

        holder.entryName.text = entry.name
        holder.entryNumber.text = entry.number
        holder.entryImage.setImageResource(entry.image)

        holder.deleteEntry.setOnClickListener {
            deleteContact(entry)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataset.lastIndex)
        }
        holder.entryCard.setOnClickListener{
            holder.itemView.findNavController().navigate(HomeFragmentDirections.
            actionHomeFragmentToDetailFragment(entry))
        }
    }

    private fun editContact(entry: Entry) {

    }

    private fun deleteContact(entry: Entry) {
        dataset.remove(entry)
    }

    // layoutManager needs to know amount of items
    override fun getItemCount(): Int {
        return dataset.size
    }
}
