package com.example.myrecyclerview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_info)

        val visitLinkedin = findViewById<ImageView>(R.id.img_linkedin)
        val visitInstagram = findViewById<ImageView>(R.id.img_instagram)
        val visitGithub = findViewById<ImageView>(R.id.img_github)

        visitLinkedin.setOnClickListener {
            val intentLinkedin = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.linkedin.com/in/asep-sutrisna-suhada-putra/")
            )
            startActivity(intentLinkedin)
        }

        visitInstagram.setOnClickListener {
            val intentInstagram =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/justsev30_/"))
            startActivity(intentInstagram)
        }

        visitGithub.setOnClickListener {
            val intentGithub =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/AxsevSutrisna"))
            startActivity(intentGithub)
        }

    }
}