package com.example.myrecyclerview

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DetailPlayer : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        val dataPlayer = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Player>(MainActivity.INTENT_PARCELABLE, Player::class.java)

        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Player>(MainActivity.INTENT_PARCELABLE)
        }


        val tvDetailName = findViewById<TextView>(R.id.detail_name)
        val tvDetailFullName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailNationality = findViewById<TextView>(R.id.tv_detail_nationality)
        val tvClub = findViewById<TextView>(R.id.tv_detail_club)
        val tvHeight = findViewById<TextView>(R.id.tv_Height)
        val tvWeight = findViewById<TextView>(R.id.tv_Weight)
        val tvDesc = findViewById<TextView>(R.id.tv_item_description)
        val imgPlayer = findViewById<CircleImageView>(R.id.detail_player_photo)
        val imgFlag = findViewById<ImageView>(R.id.detail_nationality_player)
        val imgClub = findViewById<ImageView>(R.id.detail_player_club)

        tvDetailName.text = dataPlayer!!.name
        tvDetailFullName.text = dataPlayer.fullName
        tvDetailNationality.text = dataPlayer.nationality
        tvClub.text = dataPlayer.clubName
        tvHeight.text = dataPlayer.height
        tvWeight.text = dataPlayer.weight
        tvDesc.text = dataPlayer.description
        imgPlayer.setImageResource(dataPlayer.photo)
        imgFlag.setImageResource(dataPlayer.flag)
        imgClub.setImageResource(dataPlayer.club)


    }
}