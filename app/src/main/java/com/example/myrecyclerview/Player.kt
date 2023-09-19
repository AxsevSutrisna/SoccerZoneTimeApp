package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val fullName: String,
    val nationality: String,
    val clubName: String,
    val height: String,
    val weight: String,
    val description: String,
    val flag: Int,
    val club: Int,
    val photo: Int
) : Parcelable
