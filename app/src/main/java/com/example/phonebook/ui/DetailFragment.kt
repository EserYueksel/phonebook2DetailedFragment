package com.example.phonebook.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.phonebook.R
import com.example.phonebook.data.model.Entry
import com.example.phonebook.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contact = requireArguments().getParcelable<Entry>("entry")

        if(contact != null) {
            binding.detailVacationImage.setImageResource(contact.image)
            binding.detailNameText.text = contact.name
            binding.detailNumberText.text = contact.number
        } else {
            binding.detailVacationImage.setImageResource(R.drawable.baseline_close_24)
        }

            binding.detailNameText.text = "name"
            binding.detailNumberText.text = "number"
            binding.detailCallButton.setOnClickListener {
                var number = contact!!.number
                call(number)
            }
     //   binding.detailDeleteButton.setOnClickListener {
      //      Toast.makeText(requireContext(),"Entry deleted",Toast.LENGTH_SHORT)
    //    }

    }
    fun call(number: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + number)
        startActivity(dialIntent)
    }
}
