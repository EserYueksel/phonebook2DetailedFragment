package com.example.phonebook.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entry(
    val name: String,
    val number: String,
    val image: Int
): Parcelable
